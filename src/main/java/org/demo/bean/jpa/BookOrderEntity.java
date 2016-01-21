/*
 * Created on 20 janv. 2016 ( Time 11:48:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "BOOK_ORDER"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="BOOK_ORDER", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="BookOrderEntity.countAll", query="SELECT COUNT(x) FROM BookOrderEntity x" )
} )
public class BookOrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="ID", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="DATE")
    private Date       date         ;

    @Column(name="STATE")
    private Integer    state        ;

	// "shopCode" (column "SHOP_CODE") is not defined by itself because used as FK in a link 
	// "customerCode" (column "CUSTOMER_CODE") is not defined by itself because used as FK in a link 
	// "employeeCode" (column "EMPLOYEE_CODE") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="SHOP_CODE", referencedColumnName="CODE")
    private ShopEntity shop        ;

    @ManyToOne
    @JoinColumn(name="EMPLOYEE_CODE", referencedColumnName="CODE")
    private EmployeeEntity employee    ;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_CODE", referencedColumnName="CODE")
    private CustomerEntity customer    ;

    @OneToMany(mappedBy="bookOrder", targetEntity=BookOrderItemEntity.class)
    private List<BookOrderItemEntity> listOfBookOrderItem;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BookOrderEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DATE ( DATE ) 
    public void setDate( Date date ) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }

    //--- DATABASE MAPPING : STATE ( INTEGER ) 
    public void setState( Integer state ) {
        this.state = state;
    }
    public Integer getState() {
        return this.state;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setShop( ShopEntity shop ) {
        this.shop = shop;
    }
    public ShopEntity getShop() {
        return this.shop;
    }

    public void setEmployee( EmployeeEntity employee ) {
        this.employee = employee;
    }
    public EmployeeEntity getEmployee() {
        return this.employee;
    }

    public void setCustomer( CustomerEntity customer ) {
        this.customer = customer;
    }
    public CustomerEntity getCustomer() {
        return this.customer;
    }

    public void setListOfBookOrderItem( List<BookOrderItemEntity> listOfBookOrderItem ) {
        this.listOfBookOrderItem = listOfBookOrderItem;
    }
    public List<BookOrderItemEntity> getListOfBookOrderItem() {
        return this.listOfBookOrderItem;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(date);
        sb.append("|");
        sb.append(state);
        return sb.toString(); 
    } 

}
