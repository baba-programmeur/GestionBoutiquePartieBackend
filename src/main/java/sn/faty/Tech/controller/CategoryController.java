package sn.faty.Tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.Tech.entity.Category;
import sn.faty.Tech.entity.Product;
import sn.faty.Tech.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/ajoutCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        return	categoryService.saveCategory(category);
    }

    @PostMapping("/ajoutCategories")
    public List<Category> addManyCategories(@RequestBody List<Category> categories)
    {
        return categoryService.saveCategories(categories);
    }

    @GetMapping("/rechercheCategory/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id)
    {
        return categoryService.getCategoriesById(id);
    }

    @GetMapping("/rechercheToutCategories")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping("/recherche/{name}")
    public Category getCategoryByName(@PathVariable String name)
    {
        return  categoryService.getCategoryByName(name);
    }

    @PutMapping("/modifierCategory")
    public ResponseEntity<Product> updateProduct(@RequestBody Category category)
    {
        return categoryService.updateCategories(category);
    }

    @DeleteMapping("/supprimerCategory/{id}")
    public String removeProduct(@PathVariable int id)
    {
        return categoryService.deleteCategoryById(id);
    }

    @DeleteMapping("/deleteAllCategory")
    public ResponseEntity<String> removeAllCategories()
    {
        return categoryService.deleteAllCategories();
    }
}
