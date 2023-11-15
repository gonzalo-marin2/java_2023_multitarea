package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * PASOS
 * 1.- CLIENTE ENVÍA NOMBRE
 * 2.- SERVIDOR LEE NOMBRE
 * 3.- SERVIDOR MANDA MENSAJE
 * 4.- CLIENTE LEE MENSAJE DEL SERVIDOR
 * */

//***** ES UNA COPIA DEL 17, LO VAMOS A HACER MULTITAREA *****
//***** LO PROBAMOS CON EL CLIENTE DEL EJERCICIO 18 *****
public class ServidorSaludo {

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(8000);//creamos objeto ServerSocket
			ExecutorService executor=Executors.newCachedThreadPool();
			while(true) {//bucle infinito para recibir infinitas llamadas
				System.out.println("Esperando llamadas...");//para ver las llamadas que se hacen
					Socket socket=server.accept();//devuelve un objeto socket
					executor.submit(new HiloLlamada(socket));
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}			
	}
}
