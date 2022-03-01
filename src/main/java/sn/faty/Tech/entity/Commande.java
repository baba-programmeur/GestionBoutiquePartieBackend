package sn.faty.Tech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Commande{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idCommande ;
	
    @ManyToMany
  
   @JoinTable(name="Details_Commande",
   
   joinColumns=@JoinColumn(name="idCommande"),inverseJoinColumns=@JoinColumn(name="idProduit"))
    
	private List<Product> product ;
    
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    
    @JoinColumn(name="idUser")
    
    private User user ;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="commande")
    
    private List <Details_Commande> detailsComm;
    
    
    

}
