package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.CategoryRepository;
import dev.chitra.EcommerceProductService.Repository.ProductRepository;
import dev.chitra.EcommerceProductService.dto.CreareProductRequestDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.CategoryNotFoundException;
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
    public ProductReponseDTO updateProduct(CreareProductRequestDto product, UUID id) {

        //updating product- I need to change the given dto to product first

        Product getProductFromDto=ProductEntityDTOMapper.convertDtoToProduct(product);

        Product existingProduct= productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the ID- for updating it"+id)
        );
        existingProduct.setName(product.getProductName());
        existingProduct.setDescription(product.getProductDescription());
        existingProduct.setPrice(product.getProductPrice());
        existingProduct.setImage(product.getProductImage());

        return ProductEntityDTOMapper.productEntityDTOMapperConversion(existingProduct);
 }

    @Override
    public ProductReponseDTO createProduct(CreareProductRequestDto productDto) {
       //convert dto to product to save it in repo
        Product product=ProductEntityDTOMapper.convertDtoToProduct(productDto);

        //get the category from Category table, because the requestDto is having only CatID
        //but we need to save Category obj in porduct table
        //hence find the category using the catId
        Category findCategoryOfGivenPdt=categoryRepository.findById(productDto.getCategoryId()).orElseThrow(
                ()->new CategoryNotFoundException("Category not found for the ID-"+productDto.getCategoryId())
        );
        product.setCategory(findCategoryOfGivenPdt); // everything in product obj and set and ready to save
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
    public List<ProductReponseDTO> findByPriceBetween(int minPrice, int maxPrice) {
        List<ProductReponseDTO> productReponseDTOS=new ArrayList<>();
        List<Product> filteredProducts=productRepository.findByPriceBetween(minPrice, maxPrice);
        for(Product product:filteredProducts){
            productReponseDTOS.add(ProductEntityDTOMapper.productEntityDTOMapperConversion(product));
        }
        return productReponseDTOS;
    }

    //I am goign to
}
