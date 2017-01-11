package td.td99.test;

import td.td99.entities.CountryEntity;
import td.td99.services.CountryPersistence;

public class TestCountryPersistence {
	
	public static void main(String[] args) 
	{
		System.out.println("--- TestCountryPersistence " ) ;
		CountryPersistence countryPersistence = new CountryPersistence() ;
		CountryEntity c = countryPersistence.find("FR");
		System.out.println("find('FR') : " + c );
		
		c = countryPersistence.find("WW") ;
		if ( c == null ) {
			System.out.println("WW not found");
			c = new CountryEntity();
			c.setCode("WW");
			c.setName("WW-name");
			System.out.println("WW creation...");
			countryPersistence.persist(c);
		}
		else {
			System.out.println("WW found (already exists)");
		}
		
		System.out.println("WW deletion...");
		countryPersistence.deleteById("WW");
	}
	
}
