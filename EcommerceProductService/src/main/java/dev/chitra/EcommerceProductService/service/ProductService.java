package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(UUID id) throws ProductNotFoundException;


    Boolean deleteProductById(UUID id) throws ProductNotFoundException;

    Product updateProduct(Product product, UUID id) throws ProductNotFoundException;

    Product createProduct(Product product);
    //below 3 are written after I made a JPA query in ProductRepository

    Product findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> findByPriceBetween(int minPrice, int maxPrice);
}
