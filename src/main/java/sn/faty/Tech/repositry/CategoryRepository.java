package sn.faty.Tech.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.Tech.entity.Category;
import sn.faty.Tech.entity.Product;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    //Product findProductByName(String name);
    Category findCategoryByName(String name);
}
