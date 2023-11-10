package tareas;

import java.util.concurrent.CopyOnWriteArrayList;

public class VolcadoLista implements Runnable {
	int a,b;
	//CopyOnWriteArrayList<> ya es thread safe
	CopyOnWriteArrayList<Integer> list;
	public VolcadoLista(int a, int b, CopyOnWriteArrayList<Integer> list) {
		super();
		this.a = a;
		this.b = b;
		this.list = list;
	}
	@Override
	public void run() {
		for(int i=a;i<=b;i++) {
				list.add(i);
		}
		
	}
	
	

}
