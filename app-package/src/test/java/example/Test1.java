package example;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import core.Thing;

public class Test1 {	
	
	@Test
	public void testNewItem() {
		
	//	System.out.println("class path is " + System.getProperty("java.class.path"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra");
		EntityManager em = emf.createEntityManager();
		try {
			Thing thing = new Thing();
			thing.setId(1000L);
			thing.setTitle("A Thing");
			thing.setNothing(null);
			em.persist(thing);
		} finally {
			em.close();
		}
	}
	
	@Test
	public void testQueryByPK() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT t FROM Thing t WHERE t.id = :idParam");
		query.setParameter("idParam", 1000L);
		
		List<Thing> things;
		try {
			things = query.getResultList();
		} finally {
			em.close();
		}

		assertEquals(things.get(0).getTitle(), "A Thing");

	}
	
	
	
}