package dev.chitra.EcommerceProductService.Repository;

import dev.chitra.EcommerceProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
