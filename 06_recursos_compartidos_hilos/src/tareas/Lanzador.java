package tareas;

import java.util.ArrayList;

public class Lanzador {

	public static void main(String[] args) {
		ArrayList<Integer> lista=new ArrayList<>();
		//Vector<Integer> lista=new Vector<>();//la clase Vector ya tiene el método add sincronizado
		new Thread(new VolcadoLista(1,1000,lista)).start();
		new Thread(new VolcadoLista(1001,2000,lista)).start();
		new Thread(new VolcadoLista(2001,3000,lista)).start();
		
		//una vez que terminen las tareas, ¿cuál es el tamaño de la lista?
		try {
			Thread.sleep(4000);//ponemos a dormir la aplicación para dar tiempo a que termine para poder sacar el size
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//condiciones de carrera(pdf3)
		System.out.println(lista.size());//==>ha salido 1589!! habrá que arreglarlo==>sincronización
		//hemos añadido un bloque sincronizado en VolcadoLista
	}

}
