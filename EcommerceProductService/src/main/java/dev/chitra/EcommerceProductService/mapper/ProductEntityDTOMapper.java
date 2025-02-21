package dev.chitra.EcommerceProductService.mapper;

import dev.chitra.EcommerceProductService.dto.CreareProductRequestDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Product;

/*
this DTO is important that you re filtering the data from the table to
show it to the response to the view for the customer

the main use of this DTO is to avoid sharing the unnecessary info or confidential
data to the customer or any end user
*/

public class ProductEntityDTOMapper {
    public static ProductReponseDTO productEntityDTOMapperConversion(Product product) {
        ProductReponseDTO productReponseDTO = new ProductReponseDTO();
        productReponseDTO.setProductCategory(product.getCategory().getName());
        productReponseDTO.setProductName(product.getName());
        productReponseDTO.setProductDescription(product.getDescription());
        productReponseDTO.setProductPrice(product.getPrice());
        productReponseDTO.setProductImage(product.getImage());
//        productReponseDTO.setProductId(product.getId()); //I am commenting this line after I made basemodel in entity package where I have ID as common for all tables
        return productReponseDTO;
    }

    public static Product convertDtoToProduct(CreareProductRequestDto dto) {
        Product product = new Product();
//        product.setCategory(dto.getProductCategory().);
        product.setRating(0);
        product.setName(dto.getProductName());
        product.setDescription(dto.getProductDescription());
        product.setPrice(dto.getProductPrice());
        product.setImage(dto.getProductImage());
//        productReponseDTO.setProductId(product.getId()); //I am commenting this line after I made basemodel in entity package where I have ID as common for all tables
        return product;
    }
}
