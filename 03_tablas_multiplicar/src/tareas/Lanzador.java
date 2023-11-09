package tareas;

import java.util.Scanner;

public class Lanzador {

	public static void main(String[] args) {
		
		new Thread(new TablasMultiplicar(3)).start();
		new Thread(new TablasMultiplicar(5)).start();
		new Thread(new TablasMultiplicar(8)).start();
		
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
