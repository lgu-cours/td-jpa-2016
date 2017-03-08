package td.td3.service2;

import td.entities.Author;


public class AuthorDAOTest {
	
	public static void main(String[] args) 
	{
		AuthorDAO dao = new AuthorDAO() ;
		Author a = dao.findById(12);
		if ( a != null ) {
			System.out.println("Found " + a);
		}
		else {
			System.out.println("Not found ");
		}
		
		dao.deleteById(888);
		a = new Author();
		a.setId(888);
		a.setFirstName("Emile");
		a.setLastName("Zola");
		dao.create(a);
		Author a2 = dao.findById(888);
		if ( a2 != null ) {
			System.out.println("Found " + a2);
		}
		else {
			System.out.println("Not found ");
		}
		
		a = new Author();
		a.setId(999);
		a.setFirstName("Ernest");
		a.setLastName("Hemingway");
		dao.save(a);

		Author a3 = dao.findById(999);
		if ( a3 != null ) {
			System.out.println("Found " + a3);
		}
		else {
			System.out.println("Not found ");
		}
	}
}
