package tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {
		
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new TareaAscendente());
		executor.submit(new TareaDescendente());

	}

}
