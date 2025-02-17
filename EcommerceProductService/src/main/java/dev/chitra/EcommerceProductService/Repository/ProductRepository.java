package dev.chitra.EcommerceProductService.Repository;

import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    //there are below methods using JPA query to get results

    Product findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> findByPriceBetween(int minPrice, int maxPrice);
}
