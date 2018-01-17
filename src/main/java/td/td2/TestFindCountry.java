package td.td2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.Country;

public class TestFindCountry {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static Country findCountry(EntityManager em, String code ) {
		
		Country c = new Country();
		c.setCode(code);
		log(" contains ? : " + em.contains(c) );
		
		log( "find : code = " + code );
		Country country = em.find(Country.class, code);
		if ( country != null ) {
			log( "Country #" + code + " found : " + country );
			log(" contains ? : " + em.contains(country) );
			log(" contains ? : " + em.contains(c) );
		}
		else {
			log( "Country #" + code + " not found.");
		}
		return country ;
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
		findCountry(em, "FR");
		System.out.println("----------");
		findCountry(em, "WW");
		System.out.println("==================================");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
}
