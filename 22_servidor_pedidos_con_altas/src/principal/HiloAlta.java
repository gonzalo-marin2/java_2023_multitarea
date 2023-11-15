package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Pedido;
import serializador.DeserializadorFecha;
import service.PedidosService;
import service.PedidosServiceFactory;

public class HiloAlta implements Runnable {
	final Socket socket;
	
	public HiloAlta(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		Gson gson=new GsonBuilder()//GsonBuilder
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create();
		//interactuamos con la capa service para poder insertar en la bbdd
		PedidosService service=PedidosServiceFactory.getPedidosService();
		//solo tenemos que leer, no hace falta escribir nada
		try(socket;BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream())))
		
		{
			//recogemos los datos enviados
			String json=bf.readLine();
			//deserializamos el json a un objeto pedido
			Pedido pedido=gson.fromJson(json, Pedido.class);
			//insertamos en la bbdd
			service.altaPedido(pedido);
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
