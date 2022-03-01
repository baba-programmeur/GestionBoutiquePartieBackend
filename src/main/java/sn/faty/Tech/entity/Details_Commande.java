package sn.faty.Tech.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Details_Commande {

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idDetailsCommand;
	
	@ManyToOne(fetch=FetchType.EAGER)
	
	@JoinColumn(name="idProduit")
	
	private Product product;
	
	@ManyToOne(fetch=FetchType.EAGER)
	
	@JoinColumn(name="idCommande")
	
	private Commande commande ;

}
