package td.td3.service;

import td.entities.Author;

public class WebAction {
	
	private final AuthorService authorService ;
	
	public WebAction(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	private void log(String msg) {
		System.out.println( msg );
	}

	public Author doFind(int id) {
		log("service.doFind("+ id +")" );
		return authorService.find(id);
	}

	public void doSave(Author author) {
		log("service.save(author)" );
		authorService.save(author);
	}

	public void doDelete(int id) {
		log("service.delete("+ id +")" );
		authorService.delete(id);
	}

	public void doDelete(Author author) {
		log("service.delete(author)" );
		authorService.delete(author);
	}
}
