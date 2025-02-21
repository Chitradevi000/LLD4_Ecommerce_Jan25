package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.entity.Category;

import java.util.UUID;

public interface CategoryService {
    Category getCategoryById(UUID categoryId);
}
