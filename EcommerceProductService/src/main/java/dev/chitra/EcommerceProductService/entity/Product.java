package dev.chitra.EcommerceProductService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Setter
@Getter
public class Product extends BaseModel {
//    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String image;
    private String category;

}
