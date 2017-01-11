package td.td1;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestPersistenceUnit {
	public static void main(String[] args) 
	{
		System.out.println("--- Persistence.createEntityManagerFactory(xx)...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("td"); 

		System.out.println("--- emf.getProperties() : " ) ;
		print( emf.getProperties(), "javax.persistence." ) ;

		System.out.println("--- emf.createEntityManager()...");		
		EntityManager em = emf.createEntityManager(); 

		System.out.println("'em' created. " ) ;
		
		System.out.println("--- em.getProperties() : " ) ;
		print( em.getProperties() ) ;
		
		System.out.println("----------");
		System.out.println("EntityManager class : " + em.getClass().getCanonicalName() );
		System.out.println("EntityManager isOpen() : " + em.isOpen() );
		System.out.println("----------");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
	
	public static void print(Map<String, Object> properties ) {
		print(properties, null );
	}
	
	public static void print(Map<String, Object> properties, String start ) {
		for ( Map.Entry<String, Object> entry : properties.entrySet() ) {
			if ( start == null || entry.getKey().startsWith(start)) {
				System.out.println(" . " + entry.getKey() + " = " + entry.getValue() );
			}
		}
	}	
}
