package servicelocator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Item;

public class ItemsLocator {
	
	//static String ruta="c:\\temp\\covid.json";
	static String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	
	public static Stream<Item> getJsonStream(){
		Gson gson=new Gson();
		
		//creamos objeto request
		HttpRequest request=HttpRequest.newBuilder() //creamos un objeto Builder para configurar propiedades
							.uri(URI.create(ruta))//Builder
							.GET()//Builder
							.build();//objeto http ya construido
		
		//creamos objeto HttpClient, que es el objeto que envía la petición
		HttpClient client=HttpClient.newBuilder()//Builder
				.version(Version.HTTP_1_1)//Builder
				.build();//Objeto HttpClient
		
		try {
			//lanzamos la petición con el método HttpClient send, indicando el objeto request
			//y la manera en la que queremos obtener la respuesta.
			//devuelve un objeto HttpResponse
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			//BodyHandlers.ofString() ==> tratamos la respuesta como cadena de caracteres
			//la cadena json está en el cuerpo de la respuesta y se recupera de la siguiente manera:
			String json=response.body().toString();
			Item[] items=gson.fromJson(json, Item[].class);//creamos un array de Item
			return Arrays.stream(items);//convertimos el array de Item en un array
		}
		catch(IOException | InterruptedException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
}
