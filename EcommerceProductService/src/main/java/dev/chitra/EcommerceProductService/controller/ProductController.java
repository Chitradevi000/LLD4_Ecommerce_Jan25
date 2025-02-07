package dev.chitra.EcommerceProductService.controller;

import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService; //Field injection

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> listOfProducts=productService.getAllProducts();
        return ResponseEntity.ok(listOfProducts);
    }
}
