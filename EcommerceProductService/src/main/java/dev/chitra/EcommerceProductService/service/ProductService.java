package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.dto.CreareProductRequestDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ProductService {
    List<ProductReponseDTO> getAllProducts();
    ProductReponseDTO getProductById(UUID id) throws ProductNotFoundException;


    Boolean deleteProductById(UUID id) throws ProductNotFoundException;

    ProductReponseDTO updateProduct(CreareProductRequestDto product, UUID id) throws ProductNotFoundException;

    ProductReponseDTO createProduct(CreareProductRequestDto product);
    //below 3 are written after I made a JPA query in ProductRepository

    Product findByName(String name);
    List<Product> findByCategory(Category category);
    List<ProductReponseDTO> findByPriceBetween(int minPrice, int maxPrice);
}
