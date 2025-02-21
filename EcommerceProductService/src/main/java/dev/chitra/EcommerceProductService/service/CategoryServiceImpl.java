package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.CategoryRepository;
import dev.chitra.EcommerceProductService.dto.CategoryRequestDto;
import dev.chitra.EcommerceProductService.dto.CategoryResponseDto;
import dev.chitra.EcommerceProductService.dto.ProductReponseDTO;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.exception.CategoryNotFoundException;
import dev.chitra.EcommerceProductService.mapper.CategoryEntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> getAllCategory() {

        List<Category> listOfCategory= (List<Category>) categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for(Category category:listOfCategory)
        {
            categoryResponseDtos.add(CategoryEntityDtoMapper.convertEntityToDto(category));
        }
        return categoryResponseDtos;
    }

    @Override
    public CategoryResponseDto getCategoryById(UUID id) {
        return CategoryEntityDtoMapper.convertEntityToDto(categoryRepository.findById(id).get());
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category savedCategory= categoryRepository.save(CategoryEntityDtoMapper.convertDtoToEntity(categoryRequestDto));
        return CategoryEntityDtoMapper.convertEntityToDto(savedCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(UUID catId, CategoryRequestDto categoryRequestDto) {
        //get the existingCategory from the given catId
        Category findExistingCatById=categoryRepository.findById(catId).orElseThrow(
                ()->new CategoryNotFoundException("Category not found"+catId)
        );
        findExistingCatById.setName(categoryRequestDto.getCategoryName());
        return CategoryEntityDtoMapper.convertEntityToDto(categoryRepository.save(findExistingCatById));
    }

    @Override
    public Boolean deleteCategory(UUID catId) {
        Category findExistingCatById=categoryRepository.findById(catId).orElseThrow(
                ()->new CategoryNotFoundException("Category not found"+catId)
        );
        categoryRepository.deleteById(catId);
      return true;
    }
}
