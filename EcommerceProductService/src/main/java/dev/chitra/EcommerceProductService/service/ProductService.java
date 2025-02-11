package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    Boolean deleteProductById(int id);
    Product updateProduct(Product product,int id);
    Product createProduct(Product product);
}
