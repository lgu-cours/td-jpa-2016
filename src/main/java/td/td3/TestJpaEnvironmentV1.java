package td.td3;

import javax.persistence.EntityManager;

import td.td3.service2.commons.JpaEnvironmentV1;

public class TestJpaEnvironmentV1 {
	
	public static void main(String[] args) 
	{
		System.out.println(" Class " + JpaEnvironmentV1.class );
		
		// JpaEnvironmentV1.fake() ; // Triggered the class initialization => init static variables
		
		System.out.println("--- Persistence.createEntityManagerFactory(xx)...");
		System.out.println("- Persistence Unit Name : " + JpaEnvironmentV1.getPersistenceUnitName() );
		
		EntityManager em = JpaEnvironmentV1.createEntityManager();
		System.out.println("EM is open ? " + em.isOpen() );
		em.close();

	}
}
