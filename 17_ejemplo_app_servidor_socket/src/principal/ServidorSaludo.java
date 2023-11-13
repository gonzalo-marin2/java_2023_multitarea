package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * PASOS
 * 1.- CLIENTE ENVÍA NOMBRE
 * 2.- SERVIDOR LEE NOMBRE
 * 3.- SERVIDOR MANDA MENSAJE
 * 4.- CLIENTE LEE MENSAJE DEL SERVIDOR
 * */

public class ServidorSaludo {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(8000);//creamos objeto ServerSocket
		//Hemos puesto a la escucha el objeto serversocket con su método accept
		
		
		while(true) {//bucle infinito para recibir infinitas llamadas
			System.out.println("Esperando llamadas...");//para ver las llamadas que se hacen
			try(Socket socket=server.accept();//devuelve un objeto socket
					//***** OPERACIONES ENTRADA/SALIDA *****
					OutputStream os=socket.getOutputStream();
					PrintStream out=new PrintStream(os);
					BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));)
				{
					//leemos el nombre
					String name=bf.readLine();//PASO 2
					//escribimos mensaje
					out.println("Hola "+name+", soy el servidor de sockets");//PASO 3
					System.out.println("Mensaje enviado a "+name);//para ver a quién mandamos mensaje
				}
		}
				
	}
}
