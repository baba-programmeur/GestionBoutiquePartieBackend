package sn.faty.Tech.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SousCategory {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idCodeSousCategory ;
	
	private Category codeCategory ;
	

}
