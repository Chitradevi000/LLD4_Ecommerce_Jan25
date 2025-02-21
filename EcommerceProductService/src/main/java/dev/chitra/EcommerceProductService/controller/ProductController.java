package dev.chitra.EcommerceProductService.controller;

import dev.chitra.EcommerceProductService.dto.CreareProductRequestDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.RandomException;
import dev.chitra.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService; //Field injection

    @GetMapping
    public ResponseEntity<List<ProductReponseDTO>> getAllProducts() {
        List<ProductReponseDTO> listOfProducts=productService.getAllProducts();
        return ResponseEntity.ok(listOfProducts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductReponseDTO> getProductById(@PathVariable UUID id) {
       if(id==null)
       {
           throw new RandomException("id is null which is invalid");
       }

        return ResponseEntity.ok(productService.getProductById(id));
    }

    /*
    used for checking the controlleradvise
    @GetMapping("/productexceptioncheck")
    public ResponseEntity productExceptionCheck() {
        throw new RandomException("Product is empty thrown from RandomException");
    }*/

    @PostMapping("/createproduct")
    public ResponseEntity createProduct(@RequestBody CreareProductRequestDto product) {
        ProductReponseDTO createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable UUID id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatemapping/{id}")
    public ResponseEntity updateProduct(@RequestBody Product product, @PathVariable("id") UUID id) {
        Product updatedProduct = productService.updateProduct(product, id);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/productname/{name}")
    public ResponseEntity getProductByName(@PathVariable("name") String name) {
        Product nameFiltered= productService.findByName(name);
        return ResponseEntity.ok(nameFiltered);
    }

    @GetMapping("/{minprice}/{maxprice}")
    public ResponseEntity getProductByMinPrice(@PathVariable int minprice, @PathVariable int maxprice) {
        List<Product> filterByPrice=productService.findByPriceBetween(minprice,maxprice);
        return ResponseEntity.ok(filterByPrice);
    }
}
