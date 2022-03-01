package sn.faty.Tech.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public  class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long idUser;
	
	private String nom;

	private String prenom;
	
    private String login;
	
	private String mdp;
	
	private int tel ;
	
	private String type_compte;
	
	private boolean isConnected;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="user")
	
	private List<Product> product=new ArrayList<Product>();
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="user")
	
	private List<Commande> commande;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public String getUsername() {
		return login;
	}


	public User(String nom, String prenom, int numero, String login, String mdp, String type_compte,
			boolean isConnected) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.type_compte = type_compte;
		this.isConnected = isConnected;

	}

	public void setUsername(String username) {
		this.login = username;
	}

	public String getPassword() {
		return mdp;
	}



	public void setPassword(String password) {
		this.mdp = password;
	}


	public String getType_compte() {
		return type_compte;
	}


	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}


	public boolean isConnected() {
		return isConnected;
	}


	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public int getTel() {
		return tel;
	}



	public void setTel(int tel) {
		this.tel = tel;
	}



	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}



	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
}
