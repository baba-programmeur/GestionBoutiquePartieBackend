package sn.faty.Tech.entity;

import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product  

{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idProduit;
	
	private int stockRestant ;
	
	private String name;
	
	private double price;
	
	private int quantityInitial;
	
	private byte [] image;
	
	private String description ;
	
   @ManyToMany(mappedBy="product")
	
	private List<Commande> commande;
   
	@OneToMany(mappedBy="product")
	
	private  List<Category> category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	
	@JoinColumn(name="idUser")
	
	private  User user ;
	
	
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	
	private List<Details_Commande> detailsComm;

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int idProduit, int stock, String name, double price, int quantity, byte[] image, String description,
			List<Commande> commande, List<Category> category, User user, List<Details_Commande> detailsComm) {
		super();
		this.idProduit = idProduit;
		this.stockRestant = stock;
		this.name = name;
		this.price = price;
		this.quantityInitial = quantity;
		this.image = image;
		this.description = description;
		this.commande = commande;
		this.category = category;
		this.user = user;
		this.detailsComm = detailsComm;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}



	public int getStockRestant() {
		return stockRestant;
	}



	public void setStockRestant(int stockRestant) {
		this.stockRestant = stockRestant;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantityInitial() {
		return quantityInitial;
	}



	public void setQuantityInitial(int quantityInitial) {
		this.quantityInitial = quantityInitial;
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Commande> getCommande() {
		return commande;
	}



	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}



	public List<Category> getCategory() {
		return category;
	}



	public void setCategory(List<Category> category) {
		this.category = category;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Details_Commande> getDetailsComm() {
		return detailsComm;
	}



	public void setDetailsComm(List<Details_Commande> detailsComm) {
		this.detailsComm = detailsComm;
	}

	@Override
	public String toString() {
		return "Product [idProduit=" + idProduit + ", stockRestant=" + stockRestant + ", name=" + name + ", price="
				+ price + ", quantityInitial=" + quantityInitial + ", image=" + Arrays.toString(image)
				+ ", description=" + description + ", commande=" + commande + ", category=" + category + ", user="
				+ user + ", detailsComm=" + detailsComm + "]";
	}

	
	
	
	
	
}
