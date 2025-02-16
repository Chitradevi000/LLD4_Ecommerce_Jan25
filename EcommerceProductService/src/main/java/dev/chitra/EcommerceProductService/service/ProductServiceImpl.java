package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.ProductRepository;
import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//this class will have downstream Repo
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteProductById(int id) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, int id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
       return productRepository.save(product);
    }
}
