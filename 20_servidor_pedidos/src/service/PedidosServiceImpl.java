package service;

import java.util.List;

import javax.persistence.EntityManager;

import helpers.EntityManagerLocator;
import model.Pedido;



public class PedidosServiceImpl implements PedidosService {
	
	@Override
	public List<Pedido> pedidosTienda(String tienda) {
		EntityManager em=EntityManagerLocator.getEntityManager();
		String jpql="select p from Pedido p where p.tienda=?1";
		return em
				.createQuery(jpql, Pedido.class)
				.setParameter(1, tienda)
				.getResultList();
	}
}
