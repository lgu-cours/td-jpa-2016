package td.td99.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Persistent entity
 * 
 */
@Entity
@Table(name="COUNTRY", schema="ROOT")
public class CountryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE")
	private String code;

	@Column(name="NAME")
	private String name;

	
    public CountryEntity() {
    }

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country ["
				+ "code=" + code 
				+ ", name=" + name 
				+ "]";
	}
	
	

}