package td.entities.withlinks;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "WORKGROUP"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="WORKGROUP", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="WorkgroupEntity.countAll", query="SELECT COUNT(x) FROM WorkgroupEntity x" )
} )
public class WorkgroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="ID", nullable=false)
    private Short      id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="NAME", nullable=false, length=40)
    private String     name         ;

    @Column(name="DESCRIPTION", nullable=false, length=600)
    private String     description  ;

    @Temporal(TemporalType.DATE)
    @Column(name="CREATION_DATE", nullable=false)
    private Date       creationDate ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToMany(mappedBy="listOfWorkgroup", targetEntity=EmployeeEntity.class)
    private List<EmployeeEntity> listOfEmployee;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public WorkgroupEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Short id ) {
        this.id = id ;
    }
    public Short getId() {
        return this.id;
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

    //--- DATABASE MAPPING : DESCRIPTION ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : CREATION_DATE ( DATE ) 
    public void setCreationDate( Date creationDate ) {
        this.creationDate = creationDate;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfEmployee( List<EmployeeEntity> listOfEmployee ) {
        this.listOfEmployee = listOfEmployee;
    }
    public List<EmployeeEntity> getListOfEmployee() {
        return this.listOfEmployee;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(creationDate);
        return sb.toString(); 
    } 

}
