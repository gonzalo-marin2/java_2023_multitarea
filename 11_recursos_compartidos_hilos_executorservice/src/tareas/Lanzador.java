package tareas;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		ArrayList<Integer> lista=new ArrayList<>();
		
		Future<?> f1=executor.submit(new VolcadoLista(1,1000,lista));
		Future<?> f2=executor.submit(new VolcadoLista(1001,2000,lista));
		Future<?> f3=executor.submit(new VolcadoLista(2001,3000,lista));
		
		//una vez que terminen las tareas, ¿cuál es el tamaño de la lista?
		//si alguna tarea no ha terminado, no hagas nada, por eso dejamos vacío el cuerpo del while
		while(!f1.isDone()||!f2.isDone()||!f3.isDone()) {}
		System.out.println(lista.size());
		//forzar el cierre del pool
		executor.shutdown();
	}

}
