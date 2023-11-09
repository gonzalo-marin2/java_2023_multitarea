package dao;

public class DaoFactory {
	public static FicheroPedidosDao getFicheroPedidosDao() {
		return new FicheroPedidosDaoImpl();
	}
	
	public static PedidosDao getPedidosDao() {
		return new PedidosDaoImpl();
	}
}
