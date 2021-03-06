package td.entities.withlinks;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "PUBLISHER"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="PUBLISHER", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PublisherEntity.countAll", query="SELECT COUNT(x) FROM PublisherEntity x" )
} )
public class PublisherEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="CODE", nullable=false)
    private Integer    code         ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="NAME", length=45)
    private String     name         ;

    @Column(name="EMAIL", length=45)
    private String     email        ;

    @Column(name="CONTACT", length=45)
    private String     contact      ;

    @Column(name="CITY", length=45)
    private String     city         ;

    @Column(name="ZIP_CODE")
    private Integer    zipCode      ;

    @Column(name="PHONE", length=14)
    private String     phone        ;

	// "countryCode" (column "COUNTRY_CODE") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="publisher", targetEntity=BookEntity.class)
    private List<BookEntity> listOfBook  ;

    @ManyToOne
    @JoinColumn(name="COUNTRY_CODE", referencedColumnName="CODE")
    private CountryEntity country     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PublisherEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCode( Integer code ) {
        this.code = code ;
    }
    public Integer getCode() {
        return this.code;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NAME ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : EMAIL ( VARCHAR ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //--- DATABASE MAPPING : CONTACT ( VARCHAR ) 
    public void setContact( String contact ) {
        this.contact = contact;
    }
    public String getContact() {
        return this.contact;
    }

    //--- DATABASE MAPPING : CITY ( VARCHAR ) 
    public void setCity( String city ) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }

    //--- DATABASE MAPPING : ZIP_CODE ( INTEGER ) 
    public void setZipCode( Integer zipCode ) {
        this.zipCode = zipCode;
    }
    public Integer getZipCode() {
        return this.zipCode;
    }

    //--- DATABASE MAPPING : PHONE ( VARCHAR ) 
    public void setPhone( String phone ) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfBook( List<BookEntity> listOfBook ) {
        this.listOfBook = listOfBook;
    }
    public List<BookEntity> getListOfBook() {
        return this.listOfBook;
    }

    public void setCountry( CountryEntity country ) {
        this.country = country;
    }
    public CountryEntity getCountry() {
        return this.country;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(code);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(contact);
        sb.append("|");
        sb.append(city);
        sb.append("|");
        sb.append(zipCode);
        sb.append("|");
        sb.append(phone);
        return sb.toString(); 
    } 

}
