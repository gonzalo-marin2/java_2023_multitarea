package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//lanzar dos tareas que se ejecuten concurrentemente
		//una de ellas calculará la suma de los números entre 1 y 100
		//la otra, el factorial de un número cualquiera
		//al finalizar las tareas, el programa principal muestra los resultados
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		//Primera tarea:suma
		/*Future<Integer>f1=executor.submit(()->{
			return IntStream.rangeClosed(1, 100).sum();
			//no hace falta un forEach, el método rangeClosed() nos da un intervalo de números
			//y el método sum() suma los valores de ese intervalo
		});*/
		
		//Primera tarea:suma
				Future<Integer>f1=executor.submit(()->{
					int suma=0;
					for(int i=1;i<=100;i++) {
						suma+=i;
					try {
						Thread.sleep(200);
					}
					catch(Exception ex) {}
				}
				return suma;
			});
		
		/*//Segunda tarea: factorial
		Future<Integer>f2=executor.submit(()->{
			return IntStream.rangeClosed(1, 6).reduce(1,(a,b)->a*b);
		});*/
				
		//Segunda tarea: factorial
		Future<Integer>f2=executor.submit(()->{
				int multi=1;
				for(int i=1;i<=6;i++) {
					multi*=i;
				try {
					Thread.sleep(200);
				}
				catch(Exception ex) {}
				}
				return multi;
			});
		
		while(!f1.isDone()||!f2.isDone()) {
			System.out.println("Esperando resultados....");
		}
		
		System.out.println("Suma: "+f1.get());
		System.out.println("Factorial: "+f2.get());

	}

}
