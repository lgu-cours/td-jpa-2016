package td.td3.service;

import javax.persistence.EntityManager;

import td.entities.Author;

public class AuthorServiceTD3 {

	private EntityManager em = null ;
	
	private void log(String msg ) {
		System.out.println("[LOG:AuthorService] " + msg );
	}
	
	public AuthorServiceTD3(EntityManager em) {
		super();
		this.em = em;
	}

	/**
	 * Recherche � partir de la cl� primaire
	 * @param id
	 * @return
	 */
	public Author find ( int id ) {
		log("find("+id+")");
		Author author = em.find(Author.class, id);
		return author ;
	}
	
	/**
	 * Suppression � partir de la valeur de la cl� primaire
	 * @param id
	 */
	public boolean delete ( int id ) {
		log("delete("+id+")");
		boolean result = false ;
		
		// Pour supprimer une entit� il faut qu'elle soit "managed"
		// il faut donc d'abord la charg�e dans le "persistence context" par un find 
		Author author = em.find(Author.class, id);
		
		if ( author != null ) {
			log("Found : remove it");
			removeExistingEntity(author);
			result = true ;
		}
		else {
			log("Not found (not removed)");
		}
		return result ;
	}
	
	/**
	 * Suppression � partir d'une instance
	 * @param author
	 */
	public boolean delete ( Author author ) {
		log("delete("+author+")");
		boolean result = false ;
		if ( author != null ) {
			if ( em.contains(author) ) {
				log("Author is in context : remove it" );
				removeExistingEntity(author);
				result = true ;
			}
			else {
				log("Author is NOT in context" );
				result = delete(author.getId());
			}
		}
		else {
			throw new IllegalArgumentException("Author is null");
		}
		return result ;
	}
	
	private void removeExistingEntity ( Author author ) {
		 em.getTransaction().begin();
		 em.remove(author);
		 em.getTransaction().commit();
	}

	/**
	 * Cr�ation (insert) d'une nouvelle entit� ( erreur si Duplicate Key )
	 * @param author
	 */
	public void create ( Author author) {
		log("create("+author+")");
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
	}
	
	
	/**
	 * Enregistre : cr�ation si inexistant, mise � jour si d�j� existant
	 * @param author
	 * @return
	 */
	public void save ( Author author ) {		
		log("save("+author+")");
		merge(author);
	}
	
	/**
	 * Met � jour uniquement s'il existe 
	 * @param author
	 * @return
	 */
	public boolean update ( Author author ) {		
		log("update("+author+")");
		boolean result = false ;
		if ( author != null ) {
			if ( em.contains(author) ) {
				log("Author is in context => merge" );
				merge(author);
				result = true ;
			}
			else {
				log("Author is NOT in context, search in database" );
				Author a1 = em.find(Author.class, author.getId());
				if ( a1 != null ) {
					log("Found => merge ");
					merge(author);
					result = true ;
				}
				else {
					log("Not found => cannot update it");
				}
			}
		}
		else {
			throw new IllegalArgumentException("Author is null");
		}
		return result ;
	}

	private void merge ( Author author ) {
		 em.getTransaction().begin();
		 em.merge(author);
		 em.getTransaction().commit();
	}
	
}
