package sn.faty.Tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.faty.Tech.Exception.RessourceNotFoundException;
import sn.faty.Tech.entity.Category;
import sn.faty.Tech.entity.Product;
import sn.faty.Tech.repositry.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public ResponseEntity<Category> saveCategory(Category category)
    {
       Category category1=categoryRepo.save(category);
        if(category1 != null)
        {
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public List<Category> saveCategories(List<Category> categories)
    {
        return categoryRepo.saveAll(categories);
    }
    public List<Category> getAllCategories() {

        return categoryRepo.findAll();
    }
    public ResponseEntity<Category> getCategoriesById(int id)
    {
      Category product= categoryRepo.findById(id).orElseThrow( () -> new RessourceNotFoundException("Product"+id +"n'est pas trouvé"));

        return ResponseEntity.ok().body(product);
    }

    public Category getCategoryByName(String name)
    {
        return  categoryRepo.findCategoryByName(name);
    }

    public String deleteCategoryById(int id) {

    Category category=categoryRepo.findById(id).orElseThrow(()-> new RessourceNotFoundException("Produit n'ont trouvé"));

        categoryRepo.deleteById(category.getIdCategory());
        return "la categorie d'identifiant" +id +  "a été supprime avec succés";

    }
    public ResponseEntity<String> deleteAllCategories()
    {
        List<Category> categories=categoryRepo.findAll();
     categoryRepo.deleteAll();
        return new ResponseEntity("Toutes les categories ont ete bien supprimes",HttpStatus.OK);
    }

    public ResponseEntity<Product> updateCategories(Category category) {

        Optional<Category> category1=categoryRepo.findById(category.getIdCategory());//.orElse(null);

        if(category1.isPresent())
        {
          Category existingCategory=category1.get();

            existingCategory.setName(category.getName());

            existingCategory.setName(category.getName());

            existingCategory.setLibelle(category.getLibelle());

            return new ResponseEntity(categoryRepo.save(existingCategory),HttpStatus.OK) ;
        }
        else
            return new  ResponseEntity(HttpStatus.NOT_FOUND);

    }



}
