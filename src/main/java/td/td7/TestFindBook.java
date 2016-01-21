package td.td7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.demo.bean.jpa.AuthorEntity;
import org.demo.bean.jpa.BookEntity;

public class TestFindBook {
	
	private static void log(String msg) {
		System.out.println( msg );
	}
	
	public static BookEntity findBook(EntityManager em, int id ) {
		log( "find : id = " + id );
		BookEntity book = em.find(BookEntity.class, id);
		if ( book != null ) {
			log( "Book #" + id + " found : " + book );
		}
		else {
			log( "Book #" + id + " not found.");
		}
		return book ;
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
		BookEntity book ;
		book = findBook(em, 878);
		System.out.println("----------");
		book = findBook(em, 5);
		
		if ( book != null ) {
			AuthorEntity author = book.getAuthor();
			System.out.println("Author : "+ author );
			System.out.println("Publisher : "+  book.getPublisher());
		}
		System.out.println("==================================");
		
		 // close the EM and EMF when done 
		System.out.println("--- closing EntityManager ...");
        em.close(); 
		System.out.println("EntityManager isOpen() : " + em.isOpen() );

        System.out.println("--- closing EntityManagerFactory ...");
        emf.close();			
	}
}
