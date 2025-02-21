package dev.chitra.EcommerceProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private double price;
    private int rating;
    private int quantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
