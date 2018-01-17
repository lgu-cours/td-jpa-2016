package td.td7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.withlinks.BadgeEntity;
import td.entities.withlinks.EmployeeEntity;



public class TestFindEmployee {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static EmployeeEntity findEmployee(EntityManager em, String pk ) {
		log( "find : id = " + pk );
		EmployeeEntity e = em.find(EmployeeEntity.class, pk);
		if ( e != null ) {
			log( "Employee #" + pk + " found : " + e );
		}
		else {
			log( "Employee #" + pk + " not found.");
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
		EmployeeEntity e ;
		e = findEmployee(em, "A001");
		System.out.println("----------");
		e = findEmployee(em, "A99");

		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );
		
		if ( e != null ) {
			System.out.println("getBadge : ");
			BadgeEntity badge = e.getBadge();
			System.out.println("Badge : "+ badge );
			
			System.out.println("getShop : ");
			System.out.println("Shop  : "+  e.getShop());
		}
		System.out.println("==================================");
		
		 // close the EM and EMF when done 

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
}
