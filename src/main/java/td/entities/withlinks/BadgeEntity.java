package td.entities.withlinks;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "BADGE"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="BADGE", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="BadgeEntity.countAll", query="SELECT COUNT(x) FROM BadgeEntity x" )
} )
public class BadgeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="BADGE_NUMBER", nullable=false)
    private Integer    badgeNumber  ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="AUTHORIZATION_LEVEL", nullable=false)
    private Short      authorizationLevel ;

    @Temporal(TemporalType.DATE)
    @Column(name="END_OF_VALIDITY")
    private Date       endOfValidity ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToOne(mappedBy="badge", targetEntity=EmployeeEntity.class)
    private EmployeeEntity listOfEmployee;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BadgeEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setBadgeNumber( Integer badgeNumber ) {
        this.badgeNumber = badgeNumber ;
    }
    public Integer getBadgeNumber() {
        return this.badgeNumber;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : AUTHORIZATION_LEVEL ( SMALLINT ) 
    public void setAuthorizationLevel( Short authorizationLevel ) {
        this.authorizationLevel = authorizationLevel;
    }
    public Short getAuthorizationLevel() {
        return this.authorizationLevel;
    }

    //--- DATABASE MAPPING : END_OF_VALIDITY ( DATE ) 
    public void setEndOfValidity( Date endOfValidity ) {
        this.endOfValidity = endOfValidity;
    }
    public Date getEndOfValidity() {
        return this.endOfValidity;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfEmployee( EmployeeEntity listOfEmployee ) {
        this.listOfEmployee = listOfEmployee;
    }
    public EmployeeEntity getListOfEmployee() {
        return this.listOfEmployee;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(badgeNumber);
        sb.append("]:"); 
        sb.append(authorizationLevel);
        sb.append("|");
        sb.append(endOfValidity);
        return sb.toString(); 
    } 

}