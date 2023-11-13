package tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {
		
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new TablasMultiplicar(3));
		executor.submit(new TablasMultiplicar(5));
		executor.submit(new TablasMultiplicar(8));
		
		for(int i=1;i<=10;i++) {
			System.out.println("Ejecutando main");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
