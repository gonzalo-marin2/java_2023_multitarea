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

import model.Pais;

public class PaisesLocator {
	
	static String ruta="https://restcountries.com/v2/all";
	
	public static Stream<Pais> getJsonStream(){
		Gson gson=new Gson();
		//creamos objeto request
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(ruta))
				.GET()
				.build();
		//creamos objeto HttpClient para lanzar la petición
		HttpClient client=HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.build();
		
		try {
			//lanzamos la petición
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			//String json=response.toString();
			//Pais[] paises=gson.fromJson(json, Pais[].class);
			return Arrays.stream(gson.fromJson(response.body().toString(), Pais[].class)); //Stream<Pais>
			//return Arrays.stream(paises);
		}
		catch(IOException | InterruptedException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
		
		
		
		
	}

}
