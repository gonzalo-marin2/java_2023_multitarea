package tareas;

import java.util.Scanner;

public class TablasMultiplicar implements Runnable {
	
	/*
	 * Solicita la introducción de tres números, después muestra
por pantalla las tablas de multiplicar de esos números,
de manera concurrente.

7 3 9

7x1=7
3x1=3
9x1=9
3x2=6
9x2=18
7x2=14
... 
	 * */
	
	//declaramos una variable que va a guardar el número
	private int numero;
	//creamos un constructor para que reciba el número
	public TablasMultiplicar(int numero) {
		this.numero=numero;
	}

	@Override
	public void run() {
		
		for(int i=1;i<=10;i++) {
			System.out.println(numero+"X"+i+"="+numero*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}
