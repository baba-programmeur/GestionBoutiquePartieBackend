package sn.faty.Tech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sn.faty.Tech.entity.Product;
import sn.faty.Tech.repositry.ProductRepository;

@SpringBootTest
class ProjetMysqlWebServiceSpringBootApplicationTests {

	
	@Autowired 
	
	private ProductRepository productrepo;
	@Test
	void contextLoads() {
	}
	
	@Test
   void  getProduct()
	{
		
    Product produit=productrepo.findProductByName("FatyProgramme");
		
      System.out.println(produit);
		
	}

}
