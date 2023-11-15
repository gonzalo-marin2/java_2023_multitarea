package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {
	List<Pedido> pedidosTienda(String tienda);
}
