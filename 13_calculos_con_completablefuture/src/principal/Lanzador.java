package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//lanzar dos tareas que se ejecuten concurrentemente
		//una de ellas calculará la suma de los números entre 1 y 100
		//la otra, el factorial de un número cualquiera
		//al finalizar cada tarea, el programa principal mostrará su resultado
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		//Primera tarea:suma
		//Future<Integer>f1=executor.submit(()->{
		CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(()->{
			int suma=0;
			for(int i=1;i<=100;i++) {
				suma+=i;
			try {
				Thread.sleep(100);
			}
			catch(Exception ex) {}
		}
		return suma;
	},executor);
		f1.whenCompleteAsync((r,e)->System.out.println("Suma: "+r));
		//el parámetro e es de error, se puede usar para ver si hay un null
		
		//Segunda tarea: factorial
		//Future<Integer>f2=executor.submit(()->{
		CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(()->{
			int multi=1;
			for(int i=1;i<=6;i++) {
				multi*=i;
				try {
					Thread.sleep(100);
				}
				catch(Exception ex) {}
			}
			return multi;
		},executor);
		f2.whenCompleteAsync((r,e)->System.out.println("Factorial: "+r));
		//el parámetro e es de error, se puede usar para ver si hay un null
		
		executor.shutdown();
		//si usamos la versión de stream(la primera línea comentada en cada método)
		//no se ve el resultado.
		//necesitamos usar la instrucción:
		//System.in.read();
	}

}
