package td.td3.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.Author;
import td.td3.service.AuthorService;

public class AuthorServiceTest {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static void main(String[] args) {
		log("--- Persistence.createEntityManagerFactory(xx)...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("td"); 
		
		log("--- emf.createEntityManager()...");		
		EntityManager em = emf.createEntityManager(); 
		
		log("----------");
		log("EntityManager class : " + em.getClass().getCanonicalName() );
		log("EntityManager isOpen() : " + em.isOpen() );
		log("----------");
		
		log("==================================");
		AuthorService service = new AuthorService(em);
		testService(service);
		log("==================================");
		
		 // close the EM and EMF when done 
		log("--- closing EntityManager ...");
        em.close(); 
		log("EntityManager isOpen() : " + em.isOpen() );

        log("--- closing EntityManagerFactory ...");
        emf.close();			
	}
	
	public static void testService(AuthorService service) {
		
		int id = 999 ;
		Author author ;
		
		log("service.delete("+id+")" );
		service.delete(id);
		
		log("---" );
		log("service.find("+id+")" );
		author = service.find(id);
		print(author);
		
		log("---" );
		author = new Author();
		author.setId(id);
		author.setFirstName("Emile");
		author.setLastName("Zola");
		log("new Author instance : " + author );
		
		log("service.create(author)" );
		service.create(author);
		log("service.create(author)" );
		service.create(author);
		
		log("service.create(author)" );
		service.create(author);
		
		
		log("---" );
		log("service.find("+id+")" );
		author = service.find(id);
		print(author);
		
		log("---" );
		log("service.update(author)" );
		boolean r = service.update(author);
		log("Update Author : result = " + r );
		
		log("---" );
		author.setFirstName("Emile 2");
		author.setLastName("Zola 2");
		log("service.save(author)" );
		service.save(author);

		log("---" );
		log("service.delete(author)" );
		
		log("---" );
		log("service.find("+id+")" );
		author = service.find(id);
		print(author);
	}
	public static void print(Author author) {
		if ( author != null ) {
			log("Author FOUND : " + author );
		}
		else {
			log("Author NOT FOUND ( = null )");
		}
	}
}
