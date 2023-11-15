package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * PASOS
 * 1.- CLIENTE ENVÍA NOMBRE
 * 2.- SERVIDOR LEE NOMBRE
 * 3.- SERVIDOR MANDA MENSAJE
 * 4.- CLIENTE LEE MENSAJE DEL SERVIDOR
 * */


public class ClienteSaludo {

	public static void main(String[] args) throws IOException {
		//creamos objeto socket
		//try(Socket socket=new Socket("a13e100",8000);//dirección de red del ordenador del profesor
		try(Socket socket=new Socket("localhost",8000);
		//****ENTRADA/SALIDA****
		InputStream input=socket.getInputStream();//flujo de entrada
		PrintStream out=new PrintStream(socket.getOutputStream());//flujo de salida
		//para leer el mensaje, creamos un bufferedreader
		BufferedReader bf=new BufferedReader(new InputStreamReader(input));)
		{
			//enviamos el nombre
			out.println("nombre");//PASO 1
			//leemos respuesta
			System.out.println(bf.readLine());//PASO 4
		}
		
				
	}
	

}
