package dev.chitra.EcommerceProductService.mapper;

import dev.chitra.EcommerceProductService.dto.CategoryRequestDto;
import dev.chitra.EcommerceProductService.dto.CategoryResponseDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDtoMapper {

    public static CategoryResponseDto convertEntityToDto(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(category.getId());
        categoryResponseDto.setCategoryName(category.getName());
        List<ProductReponseDTO> productReponseDTOList = new ArrayList<>();
        if(category.getProducts() != null && category.getProducts().size() > 0) {
            for (Product product : category.getProducts()) {
                productReponseDTOList.add(ProductEntityDTOMapper.productEntityDTOMapperConversion(product));
            }
        }
        categoryResponseDto.setListOfProducts(productReponseDTOList);
        return categoryResponseDto;
    }

    public static Category convertDtoToEntity(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getCategoryName());
        return category;
    }
}
