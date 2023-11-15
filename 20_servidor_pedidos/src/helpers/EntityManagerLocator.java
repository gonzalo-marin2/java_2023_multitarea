package helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerLocator {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("pedidosPU");
		return factory.createEntityManager();
	}

}
