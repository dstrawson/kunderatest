package example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

import core.Thing;

public class Test1 {	
	
	@Test
	public void testNewItem() {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra");
		EntityManager em = emf.createEntityManager();
		try {
			Thing thing = new Thing();
			thing.setId(1000L);
			thing.setTitle("A Thing");
			em.persist(thing);
		} finally {
			em.close();
		}
	}
}