package dev.chitra.EcommerceProductService.Repository;

import dev.chitra.EcommerceProductService.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends CrudRepository<Category, UUID> {

}
