package td.td3.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import td.entities.Author;
import td.td3.service.AuthorService;

public class WebActionTest {
	
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
		WebAction webAction = new WebAction(new AuthorService(em));
		testWebAction(webAction);
		log("==================================");
		
		 // close the EM and EMF when done 
		log("--- closing EntityManager ...");
        em.close(); 
		log("EntityManager isOpen() : " + em.isOpen() );

        log("--- closing EntityManagerFactory ...");
        emf.close();			
	}
	
	public static void testWebAction(WebAction webAction) {
		
		int id = 999 ;
		Author author ;
		
		log("webAction.delete("+id+")" );
		webAction.doDelete(id);
		
		log("---" );
		log("webAction.find("+id+")" );
		author = webAction.doFind(id);
		print(author);
		
		log("---" );
		author = new Author();
		author.setId(id);
		author.setFirstName("Emile");
		author.setLastName("Zola");
		log("new Author instance : " + author );
		
		log("---" );
		author.setFirstName("Emile 2");
		author.setLastName("Zola 2");
		log("service.save(author)" );
		webAction.doSave(author);

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
