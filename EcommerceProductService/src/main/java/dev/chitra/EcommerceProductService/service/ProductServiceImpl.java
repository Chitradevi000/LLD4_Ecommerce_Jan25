package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.CategoryRepository;
import dev.chitra.EcommerceProductService.Repository.ProductRepository;
import dev.chitra.EcommerceProductService.dto.CreareProductRequestDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import dev.chitra.EcommerceProductService.mapper.ProductEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//this class will have downstream Repo
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductReponseDTO> getAllProducts() {
        List<Product> getAllProducts=productRepository.findAll();
        //map the Product_to_DTO
        List<ProductReponseDTO> productReponseDTOS=new ArrayList<>();
        for(Product product:getAllProducts){
            productReponseDTOS.add(ProductEntityDTOMapper.productEntityDTOMapperConversion(product));

        }
        return productReponseDTOS;
    }

    @Override
    public ProductReponseDTO getProductById(UUID id) throws ProductNotFoundException {
        /*Product sindleProduct=productRepository.findById(id).get();
        if(sindleProduct==null)
        {
            throw new ProductNotFoundException("Product not found");
        }
        return sindleProduct;*/

        //above is the simple code
        /*below is the code simplified , Note: findByID will return optional
        which will do the null check , thats where we have implemented lambda*/
        Product getProductById= productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the ID- "+id)
        );
        return ProductEntityDTOMapper.productEntityDTOMapperConversion(getProductById);
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
    public ProductReponseDTO createProduct(CreareProductRequestDto productDto) {
       //convert dto to product before repo
        Product product=ProductEntityDTOMapper.convertDtoToMapper(productDto);
        Product createdProduct= productRepository.save(product);
        return ProductEntityDTOMapper.productEntityDTOMapperConversion(createdProduct);

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
