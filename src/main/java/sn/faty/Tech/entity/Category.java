package sn.faty.Tech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity 

public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private int idCategory;  	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY )
	
	@JoinColumn(name="idProduit")
	
	 private Product  product;

	private String name;

	private String libelle ;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	} ;
	 
	 
	 
	
}
