package td.td3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.Author;
import td.td3.service.AuthorService;

public class TestCRUDAuthor {
	
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
		AuthorService service = new AuthorService(em);
		Author author = service.find(1);
		System.out.println("Author " + author != null ? "FOUND" : "NOT FOUND");
		

		System.out.println("==================================");
		
		System.out.println("contains ? " + em.contains(author) );
		author.setFirstName("FirstName 2");
		service.create(author);
		
		System.out.println("contains ? " + em.contains(author) );
		author.setFirstName("FirstName 3");
		service.create(author);
		
		em.getTransaction().begin();
		author = service.find(1);
		System.out.println("contains ? " + em.contains(author) );

		System.out.println("set FirstName 4 and persist");
		author.setFirstName("FirstName 4");
		em.persist(author);

		System.out.println("set FirstName 5 and persist");
		author.setFirstName("FirstName 5");
		em.persist(author);
		
		em.getTransaction().commit();
		
		
		System.out.println("==================================");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
}
