package tareas;

import java.util.ArrayList;

public class VolcadoLista implements Runnable {
	int a,b;
	ArrayList<Integer> list;
	public VolcadoLista(int a, int b, ArrayList<Integer> list) {
		super();
		this.a = a;
		this.b = b;
		this.list = list;
	}
	@Override
	public void run() {
		for(int i=a;i<=b;i++) {
			//sincronización:
			synchronized (list) {//thread safe
				list.add(i);
			}
			
		}
		
	}
	
	

}
