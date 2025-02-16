package dev.chitra.EcommerceProductService.controller;

import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.RandomException;
import dev.chitra.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService; //Field injection

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> listOfProducts=productService.getAllProducts();
        return ResponseEntity.ok(listOfProducts);
    }
    @GetMapping("/product/{id}")
    public FakeStoreProductResponseDTO getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/productexceptioncheck")
    public ResponseEntity productExceptionCheck() {
        throw new RandomException("Product is empty thrown from RandomException");
    }

    @PostMapping("/createproduct")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }
}
