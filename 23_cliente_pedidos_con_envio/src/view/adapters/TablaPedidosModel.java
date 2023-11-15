package view.adapters;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pedido;
import service.PedidosServiceFactory;

public class TablaPedidosModel extends AbstractTableModel {
	
	List<Pedido> pedidos;
	final int COLS=3;
	
	public TablaPedidosModel(String tienda) {
		pedidos=PedidosServiceFactory.getPedidosService().pedidosTienda(tienda);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pedidos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLS;
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "Producto";
		case 1:
			return "Precio";
		case 2:
			return "Fecha Pedido";
		default:
			return "Indeterminada";
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
		case 0:
			return pedidos.get(row).getProducto();
		case 1:
			return pedidos.get(row).getPrecio();
		case 2:
			return pedidos.get(row).getFechaPedido();
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Double.class;
		case 2:
			return LocalDate.class;
		default:
			return null;
	}
	}

	
}
