package dev.chitra.EcommerceProductService.Controller;


import dev.chitra.EcommerceProductService.Repository.CategoryRepository;
import dev.chitra.EcommerceProductService.controller.CategoryController;
import dev.chitra.EcommerceProductService.dto.CategoryRequestDto;
import dev.chitra.EcommerceProductService.dto.CategoryResponseDto;
import dev.chitra.EcommerceProductService.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

//know about H2 DB
//when the integration of H2 is required?
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;
    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    //we gonna test the below API
    /*
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable("id") UUID id, @RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequestDto));
    }
     */

    @Test
    public void testUpdateCategorySuccess()
    {
        //arrange
        /*
        here I need to set the input with values and Mock it
        UUID and categoryRequestDto are the i/p's
         */

        UUID categoryId = UUID.randomUUID();
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setCategoryName("TestCategoryName");

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(categoryId);
        categoryResponseDto.setCategoryName("TestCategoryName");
        Mockito.when(categoryService.updateCategory(categoryId, categoryRequestDto)).thenReturn(categoryResponseDto);

        //act
        /*
        Mock is ready above , Make the actual ready to compare
         */
        ResponseEntity<CategoryResponseDto> response = categoryController.updateCategory(categoryId, categoryRequestDto);

        //assert
        Assertions.assertEquals(response.getBody(), categoryResponseDto);

    }

}
