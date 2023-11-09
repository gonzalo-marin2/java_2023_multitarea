package tareas;

public class Lanzador {

	public static void main(String[] args) {
		//Creamos las tareas
		TareaAscendente ta=new TareaAscendente();
		TareaDescendente td=new TareaDescendente();
		//las ponemos en ejecución concurrente
		ta.start();
		td.start();

	}

}
