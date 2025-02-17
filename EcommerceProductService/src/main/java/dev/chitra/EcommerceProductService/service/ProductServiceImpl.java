package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.ProductRepository;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//this class will have downstream Repo
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) throws ProductNotFoundException {
        /*Product sindleProduct=productRepository.findById(id).get();
        if(sindleProduct==null)
        {
            throw new ProductNotFoundException("Product not found");
        }
        return sindleProduct;*/

        //above is the simple code
        /*below is the code simplified , Note: findByID will return optional
        which will do the null check , thats where we have implemented lambda*/
        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the ID- "+id)
        );
    }



    @Override
    public Boolean deleteProductById(UUID id) {
        productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the ID for Delete operation- "+id)
        );
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product updateProduct(Product product, UUID id) {
       Product existingProduct= productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the ID- for updating it"+id)
        );
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setImage(product.getImage());
        return productRepository.save(existingProduct);
 }

    @Override
    public Product createProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByPriceBetween(int minPrice, int maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    //I am goign to
}
