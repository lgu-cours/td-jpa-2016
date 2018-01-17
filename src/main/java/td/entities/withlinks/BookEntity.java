package td.entities.withlinks;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

/**
* Persistent class for entity stored in table "BOOK"
*
* @author Telosys Tools Generator
*
*/

@Entity
@Table(name="BOOK", schema="ROOT" )
//Define named queries here
@NamedQueries ( {
@NamedQuery ( name="BookEntity.countAll", query="SELECT COUNT(x) FROM BookEntity x" )
} )
public class BookEntity implements Serializable {

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
  @Column(name="ISBN", nullable=false, length=13)
  private String     isbn         ;

  @Column(name="TITLE", length=160)
  private String     title        ;

  @Column(name="PRICE")
  private BigDecimal price        ;

  @Column(name="QUANTITY")
  private Integer    quantity     ;

  @Column(name="DISCOUNT")
  private Integer    discount     ;

  @Column(name="AVAILABILITY")
  private Short      availability ;

  @Column(name="BEST_SELLER")
  private Short      bestSeller   ;

	// "publisherId" (column "PUBLISHER_ID") is not defined by itself because used as FK in a link 
	// "authorId" (column "AUTHOR_ID") is not defined by itself because used as FK in a link 


  //----------------------------------------------------------------------
  // ENTITY LINKS ( RELATIONSHIP )
  //----------------------------------------------------------------------
  @ManyToOne( fetch=FetchType.LAZY)
  @JoinColumn(name="AUTHOR_ID", referencedColumnName="ID")
  private AuthorEntity author      ;

  @OneToMany(mappedBy="book", targetEntity=BookOrderItemEntity.class)
  private List<BookOrderItemEntity> listOfBookOrderItem;

  @OneToMany(mappedBy="book", targetEntity=SynopsisEntity.class)
  private List<SynopsisEntity> listOfSynopsis;

  @OneToMany(mappedBy="book", targetEntity=ReviewEntity.class)
  private List<ReviewEntity> listOfReview;

  @ManyToOne
  @JoinColumn(name="PUBLISHER_ID", referencedColumnName="CODE")
  private PublisherEntity publisher   ;


  //----------------------------------------------------------------------
  // CONSTRUCTOR(S)
  //----------------------------------------------------------------------
  public BookEntity() {
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
  //--- DATABASE MAPPING : ISBN ( VARCHAR ) 
  public void setIsbn( String isbn ) {
      this.isbn = isbn;
  }
  public String getIsbn() {
      return this.isbn;
  }

  //--- DATABASE MAPPING : TITLE ( VARCHAR ) 
  public void setTitle( String title ) {
      this.title = title;
  }
  public String getTitle() {
      return this.title;
  }

  //--- DATABASE MAPPING : PRICE ( DECIMAL ) 
  public void setPrice( BigDecimal price ) {
      this.price = price;
  }
  public BigDecimal getPrice() {
      return this.price;
  }

  //--- DATABASE MAPPING : QUANTITY ( INTEGER ) 
  public void setQuantity( Integer quantity ) {
      this.quantity = quantity;
  }
  public Integer getQuantity() {
      return this.quantity;
  }

  //--- DATABASE MAPPING : DISCOUNT ( INTEGER ) 
  public void setDiscount( Integer discount ) {
      this.discount = discount;
  }
  public Integer getDiscount() {
      return this.discount;
  }

  //--- DATABASE MAPPING : AVAILABILITY ( SMALLINT ) 
  public void setAvailability( Short availability ) {
      this.availability = availability;
  }
  public Short getAvailability() {
      return this.availability;
  }

  //--- DATABASE MAPPING : BEST_SELLER ( SMALLINT ) 
  public void setBestSeller( Short bestSeller ) {
      this.bestSeller = bestSeller;
  }
  public Short getBestSeller() {
      return this.bestSeller;
  }


  //----------------------------------------------------------------------
  // GETTERS & SETTERS FOR LINKS
  //----------------------------------------------------------------------
  public void setAuthor( AuthorEntity author ) {
      this.author = author;
  }
  public AuthorEntity getAuthor() {
      return this.author;
  }

  public void setListOfBookOrderItem( List<BookOrderItemEntity> listOfBookOrderItem ) {
      this.listOfBookOrderItem = listOfBookOrderItem;
  }
  public List<BookOrderItemEntity> getListOfBookOrderItem() {
      return this.listOfBookOrderItem;
  }

  public void setListOfSynopsis( List<SynopsisEntity> listOfSynopsis ) {
      this.listOfSynopsis = listOfSynopsis;
  }
  public List<SynopsisEntity> getListOfSynopsis() {
      return this.listOfSynopsis;
  }

  public void setListOfReview( List<ReviewEntity> listOfReview ) {
      this.listOfReview = listOfReview;
  }
  public List<ReviewEntity> getListOfReview() {
      return this.listOfReview;
  }

  public void setPublisher( PublisherEntity publisher ) {
      this.publisher = publisher;
  }
  public PublisherEntity getPublisher() {
      return this.publisher;
  }


  //----------------------------------------------------------------------
  // toString METHOD
  //----------------------------------------------------------------------
  public String toString() { 
      StringBuffer sb = new StringBuffer(); 
      sb.append("["); 
      sb.append(id);
      sb.append("]:"); 
      sb.append(isbn);
      sb.append("|");
      sb.append(title);
      sb.append("|");
      sb.append(price);
      sb.append("|");
      sb.append(quantity);
      sb.append("|");
      sb.append(discount);
      sb.append("|");
      sb.append(availability);
      sb.append("|");
      sb.append(bestSeller);
      return sb.toString(); 
  } 

}