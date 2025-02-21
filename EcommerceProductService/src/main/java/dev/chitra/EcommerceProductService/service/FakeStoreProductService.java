package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.client.FakeStoreClient;
import dev.chitra.EcommerceProductService.dto.FakeStoreDto.FakeStoreProductResponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> listOfFakeProducts=fakeStoreClient.getAllProducts();
        return listOfFakeProducts;
    }

    public FakeStoreProductResponseDTO getProductById(int id) throws ProductNotFoundException{
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO=fakeStoreClient.getSingleProduct(id);
        if(fakeStoreProductResponseDTO==null)
        {
            /*
            create an custom exception and throw
             */
            throw new ProductNotFoundException("The product ID is not found -"+id);
        }
        return fakeStoreProductResponseDTO;
    }

    public Boolean deleteProductById(int id) {
        return null;
    }

    public Product updateProduct(Product product, int id) {
        return null;
    }

    public Product createProduct(Product product) {
        return null;
    }
}
