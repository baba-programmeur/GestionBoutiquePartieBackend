package sn.faty.Tech.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.faty.Tech.Exception.RessourceNotFoundException;
import sn.faty.Tech.entity.Product;
import sn.faty.Tech.repositry.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	
	private  ProductRepository productrepo;
		
	public ResponseEntity<Product> saveProduct(Product product)
	{
		Product productAjoute= productrepo.save(product);
		 if(productAjoute != null)
		{
			return  new ResponseEntity<>(HttpStatus.OK);
		}
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	public List<Product> saveProducts(List<Product> products)
	{
		return productrepo.saveAll(products);
	}

	public List<Product> getAllProducts() {

		return productrepo.findAll();

		//return products;
	}
	public ResponseEntity<Product> getProductById(int id)
	{
		Product product= productrepo.findById(id).orElseThrow( () -> new RessourceNotFoundException("Product"+id +"n'est pas trouvé"));

		return ResponseEntity.ok().body(product);
	}
	/*
	public Product getProductByName(String name)
	{
		return  productrepo.findProductByName(name);
		
	}*/

	public String deleteProductById(int id) {

	Product product=productrepo.findById(id).orElseThrow(()-> new RessourceNotFoundException("Produit n'ont trouvé"));

	productrepo.deleteById(product.getIdProduit());
		
         return "le produit d'identifiant" +id +  "a été supprime avec succés";
		
	}


	public ResponseEntity<String> deleteAllProduct()
	{
		List<Product> products=productrepo.findAll();
    productrepo.deleteAll();
	return new ResponseEntity("Tous les produits ont ete bien supprimes",HttpStatus.OK);
	
	}
	
	  public ResponseEntity<Product> updateProduct(Product product) {
		   
		   Optional<Product> produit=productrepo.findById(product.getIdProduit());//.orElse(null);

		  if(produit.isPresent())
		  {
			   Product existingProduct=produit.get();

			  existingProduct.setName(product.getName());

			  existingProduct.setPrice(product.getPrice());

			  existingProduct.setQuantityInitial(product.getQuantityInitial());

			  return new ResponseEntity(productrepo.save(existingProduct),HttpStatus.OK) ;
		  }
		  else
		return new  ResponseEntity(HttpStatus.NOT_FOUND);

	   }	   
}