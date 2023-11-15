package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorAltaPedidos {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(9000);//creamos objeto ServerSocket
			ExecutorService executor=Executors.newCachedThreadPool();
			while(true) {//bucle infinito para recibir infinitas llamadas
				System.out.println("Esperando llamadas...");//para ver las llamadas que se hacen
					Socket socket=server.accept();//devuelve un objeto socket
					executor.submit(new HiloAlta(socket));
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}

	}

}
