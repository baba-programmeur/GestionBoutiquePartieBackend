package sn.faty.Tech.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.faty.Tech.entity.Product;

 
public interface ProductRepository  extends JpaRepository<Product,Integer>

{
  Product findProductByName(String name);

   
}
