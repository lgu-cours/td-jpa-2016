package td.td4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.records.EmployeeJpaRecord;

public class TestFindEmployee {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static EmployeeJpaRecord findEmployee(EntityManager em, String pk ) {
		log( "find : id = " + pk );
		EmployeeJpaRecord employee = em.find(EmployeeJpaRecord.class, pk);
		if ( employee != null ) {
			log( "PK " + pk + " found : " + employee );
		}
		else {
			log( "PK " + pk + " not found.");
		}
		return employee ;
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
		EmployeeJpaRecord e = findEmployee(em, "A001");
		if ( e != null ) {
			System.out.println("employee : " + e);
			System.out.println("get badbge");
	
			// Lazy loading 
			System.out.println("badge    : " + e.getBadge() );
		}
		
		System.out.println("----------");
		findEmployee(em, "ZZZZ");
		System.out.println("==================================");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();	
        
		// ERROR ( em is closed )
        // System.out.println("badge    : " + e.getBadge() );

	}
}
