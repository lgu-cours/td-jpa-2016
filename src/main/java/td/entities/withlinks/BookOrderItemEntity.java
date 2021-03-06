package td.entities.withlinks;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "BOOK_ORDER_ITEM"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="BOOK_ORDER_ITEM", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="BookOrderItemEntity.countAll", query="SELECT COUNT(x) FROM BookOrderItemEntity x" )
} )
public class BookOrderItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    private BookOrderItemEntityKey compositePrimaryKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="QUANTITY", nullable=false)
    private Integer    quantity     ;

    @Column(name="PRICE", nullable=false)
    private BigDecimal price        ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="BOOK_ORDER_ID", referencedColumnName="ID", insertable=false, updatable=false)
    private BookOrderEntity bookOrder   ;

    @ManyToOne
    @JoinColumn(name="BOOK_ID", referencedColumnName="ID", insertable=false, updatable=false)
    private BookEntity book        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BookOrderItemEntity() {
		super();
		this.compositePrimaryKey = new BookOrderItemEntityKey();       
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    public void setBookOrderId( Integer bookOrderId ) {
        this.compositePrimaryKey.setBookOrderId( bookOrderId ) ;
    }
    public Integer getBookOrderId() {
        return this.compositePrimaryKey.getBookOrderId() ;
    }
    public void setBookId( Integer bookId ) {
        this.compositePrimaryKey.setBookId( bookId ) ;
    }
    public Integer getBookId() {
        return this.compositePrimaryKey.getBookId() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : QUANTITY ( INTEGER ) 
    public void setQuantity( Integer quantity ) {
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    //--- DATABASE MAPPING : PRICE ( DECIMAL ) 
    public void setPrice( BigDecimal price ) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return this.price;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setBookOrder( BookOrderEntity bookOrder ) {
        this.bookOrder = bookOrder;
    }
    public BookOrderEntity getBookOrder() {
        return this.bookOrder;
    }

    public void setBook( BookEntity book ) {
        this.book = book;
    }
    public BookEntity getBook() {
        return this.book;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        if ( compositePrimaryKey != null ) {  
            sb.append(compositePrimaryKey.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
        sb.append(quantity);
        sb.append("|");
        sb.append(price);
        return sb.toString(); 
    } 

}
