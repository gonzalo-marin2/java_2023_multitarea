package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class HiloLlamada implements Runnable {
	final Socket socket;
	public HiloLlamada(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		//recoger el nombre enviado el cliente y enviarle
		//mensaje de saludo personalizado
		try(socket;PrintStream out=new PrintStream(socket.getOutputStream());
			BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			){
			//recogemos el nombre de tienda enviado por cliente
			String tienda=bf.readLine();
			System.out.println(tienda);
			//recuperamos lista pedidos
			PedidosService service=PedidosServiceFactory.getPedidosService();
			List<Pedido> pedidos=service.pedidosTienda(tienda);
			System.out.println(pedidos);
			System.out.println(serializarLista(pedidos));
			out.println(serializarLista(pedidos));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}
	//este método transforma la lista de pedidos en una cadena JSON
		//para lo cual, tiene que definir un serializador que indique como transformar
		//LocalDate a String
		private String serializarLista(List<Pedido> pedidos) {
			final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {@Override
				public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
					return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
				}
		    }).create();
			return  gson.toJson(pedidos.toArray(new Pedido[0]),Pedido[].class);
			//return gson.toJson(pedidos,new TypeToken<List<Pedido>>(){}.getType());
		}
}
