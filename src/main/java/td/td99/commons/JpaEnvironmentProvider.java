package td.td99.commons;

public class JpaEnvironmentProvider {

	// Single instance
	private final static JpaEnvironment environment = 
			new JpaEnvironment(JpaPersistenceUnit.PERSISTANCE_UNIT_NAME);

	/**
	 * Returns the single instance
	 * @return
	 */
	public final static JpaEnvironment getJpaEnvironment() {
		return environment ;
	}
}
