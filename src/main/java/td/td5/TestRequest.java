package td.td5;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.Author;

public class TestRequest {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static Author findAuthor(EntityManager em, int id ) {
		log( "find : id = " + id );
		Author author = em.find(Author.class, id);
		if ( author != null ) {
			log( "Author #" + id + " found : " + author );
		}
		else {
			log( "Author #" + id + " not found.");
		}
		return author ;
	}
	
	public static void authorsList(AuthorServiceTD5 service, String lastName ) {
		System.out.println("Authors list for last name = '" + lastName + "'");
		List<Author> list = service.listByLastName(lastName);
		System.out.println("Result count  = " + list.size() );
		for ( Author a : list ) {
			System.out.println(" . " + a);
		}
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
		AuthorServiceTD5 service = new AuthorServiceTD5(em);
//		Author author = service.find(1);

		List<Author> list = service.listAll();
		System.out.println("Result count  = " + list.size() );
		for ( Author a : list ) {
			System.out.println(" . " + a);
		}
		
		authorsList(service, "Zola");
		authorsList(service, "V*");
//		list = service.listByLastName("V%");
//		System.out.println("Result count  = " + list.size() );
//		for ( Author a : list ) {
//			System.out.println(" . " + a);
//		}

		System.out.println("==================================");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
}
