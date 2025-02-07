package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProductById(int id);
    Boolean deleteProductById(int id);
    Product updateProduct(Product product,int id);
    Product createProduct(Product product);
}
