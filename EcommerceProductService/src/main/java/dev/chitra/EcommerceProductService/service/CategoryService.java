package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.dto.CategoryRequestDto;
import dev.chitra.EcommerceProductService.dto.CategoryResponseDto;
import dev.chitra.EcommerceProductService.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface CategoryService {
    List<CategoryResponseDto> getAllCategory();
    CategoryResponseDto getCategoryById(UUID id);
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto updateCategory(UUID catId,CategoryRequestDto categoryRequestDto);
    Boolean deleteCategory(UUID catId);
}
