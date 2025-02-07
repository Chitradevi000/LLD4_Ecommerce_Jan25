package dev.chitra.EcommerceProductService.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String image;
    private String category;

}
