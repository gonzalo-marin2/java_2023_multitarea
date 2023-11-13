package tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.PedidosService;
import service.PedidosServiceFactory;

public class Lanzador {

	static String ruta1="c:\\temp\\pedidos\\tienda1.json";
	static String ruta2="c:\\temp\\pedidos\\tienda2.json";
	static String ruta3="c:\\temp\\pedidos\\tienda3.json";
	
	public static void main(String[] args) {
		/*new Thread(new TareasPedidos("c:\\temp\\pedidos\\tienda1.json")).start();
		new Thread(new TareasPedidos("c:\\temp\\pedidos\\tienda2.json")).start();
		new Thread(new TareasPedidos("c:\\temp\\pedidos\\tienda3.json")).start();*/
		
		/*PedidosService service=PedidosServiceFactory.getPedidosService();
		new Thread(()->{
			List<Pedido> pedidos=service.pedidosTienda(ruta1, "tienda1");
			service.guardarPedidos(pedidos);
		}).start();
		
		new Thread(()->{
			List<Pedido> pedidos=service.pedidosTienda(ruta2, "tienda2");
			service.guardarPedidos(pedidos);
		}).start();
		
		new Thread(()->{
			List<Pedido> pedidos=service.pedidosTienda(ruta3, "tienda3");
			service.guardarPedidos(pedidos);
		}).start();*/

		//TODAVÍA SE MEJORA MÁS
		PedidosService service=PedidosServiceFactory.getPedidosService();
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(()->service.guardarPedidos(service.pedidosTienda(ruta1, "tienda1")));
		executor.submit(()->service.guardarPedidos(service.pedidosTienda(ruta2, "tienda2")));
		executor.submit(()->service.guardarPedidos(service.pedidosTienda(ruta3, "tienda3")));
		

	}

}
