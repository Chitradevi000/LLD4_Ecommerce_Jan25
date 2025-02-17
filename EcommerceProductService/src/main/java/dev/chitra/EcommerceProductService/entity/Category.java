package dev.chitra.EcommerceProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    private String name;
    @OneToMany // one category have many pdts
    private List<Product> products;
}
