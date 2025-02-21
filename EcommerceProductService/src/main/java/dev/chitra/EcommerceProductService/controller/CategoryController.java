package dev.chitra.EcommerceProductService.controller;

import dev.chitra.EcommerceProductService.dto.CategoryRequestDto;
import dev.chitra.EcommerceProductService.dto.CategoryResponseDto;
import dev.chitra.EcommerceProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //get all categories
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    //get category by Id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable("id") UUID id, @RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMapping(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

}
