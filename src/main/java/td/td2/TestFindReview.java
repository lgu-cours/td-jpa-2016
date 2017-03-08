package td.td2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.demo.bean.jpa.ReviewEntity;
import org.demo.bean.jpa.ReviewEntityKey;

public class TestFindReview {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static ReviewEntity find(EntityManager em, ReviewEntityKey pk ) {
		log( "find : PK = " + pk );
		ReviewEntity e = em.find(ReviewEntity.class, pk);
		if ( e != null ) {
			log( "Review #" + pk + " found : " + e );
		}
		else {
			log( "Review #" + pk + " not found.");
		}
		return e ;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("--- Persistence.createEntityManagerFactory(xx)...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("td"); 
		
		System.out.println("--- emf.createEntityManager()...");		
		EntityManager em = emf.createEntityManager(); 
		
		System.out.println("----------");
		System.out.println("EntityManager class : " + em.getClass().getCanonicalName() );
		System.out.println("EntityManager isOpen() : " + em.isOpen() );
		System.out.println("----------");
		
		System.out.println("==================================");
		find(em, new ReviewEntityKey("zzz", 1));
		System.out.println("----------");
		find(em, new ReviewEntityKey("C0004", 3));
		System.out.println("==================================");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
}
