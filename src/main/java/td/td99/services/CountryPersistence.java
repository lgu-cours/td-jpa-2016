/*
 * Created on 2017-01-02 ( Date ISO 2017-01-02 - Time 19:04:15 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package td.td99.services ;


import java.util.List;

import td.td99.commons.GenericJpaService;
import td.td99.entities.CountryEntity;

/**
 * Car persistence service - JPA implementation 
 * 
 */
public class CountryPersistence extends GenericJpaService<CountryEntity, String> {

	/**
	 * Constructor
	 */
	public CountryPersistence() {
		super(CountryEntity.class);
	}

	//@Override
	public CountryEntity findById( String code ) {
		CountryEntity entity = super.find( code );
		//return mapper.mapEntityToRecord(entity);	
		return entity;	
	}

	//@Override
	public List<CountryEntity> findAll() {
		List<CountryEntity> entities = super.loadAll() ;
//		List<CountryEntity> records = new java.util.LinkedList<CountryEntity>();
//		for ( CountryEntity entity : entities ) {
//			records.add( mapper.mapEntityToRecord(entity) ) ;
//		}
//		return records ;
		return entities ;
	}

//	@Override
//	public CountryEntity create(CountryEntity record) {
	public CountryEntity create(CountryEntity entity) {
//		CountryEntity entity = mapper.mapRecordToEntity(record);
		super.persist(entity);
//		return record ;
		return entity ;
	}
	
//	@Override
//	public boolean update(CountryEntity record) {
	public boolean update(CountryEntity entity) {
//		Integer pk = record.getId() ;
//		if ( super.find( pk ) != null ) {
//			// Exists => 'merge' 
//			CountryEntity entity = mapper.mapRecordToEntity(record);
//			super.merge(entity);
//			return true ;
//		}
//		else {
//			return false;
//		}
		String pk = entity.getCode();
		if ( super.find( pk ) != null ) {
			// Exists => 'merge' 
			super.merge(entity);
			return true ;
		}
		else {
			return false;
		}
	}

//	@Override
//	public CountryEntity save(CountryEntity record) {
	public CountryEntity save(CountryEntity entity) {
//		CountryEntity entity = mapper.mapRecordToEntity(record);
		super.merge(entity);
//		return record ;
		return entity ;
	}

//	@Override
	public boolean deleteById( String code ) {
		return super.remove( code );
	}

//	@Override
	public boolean delete(CountryEntity entity) {
		if ( entity != null ) {
			return super.remove( entity.getCode() );
		}
		return false ;
	}

}
