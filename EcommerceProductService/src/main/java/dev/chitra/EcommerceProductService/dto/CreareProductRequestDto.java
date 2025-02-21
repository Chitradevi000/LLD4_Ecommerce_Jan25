package dev.chitra.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreareProductRequestDto {
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImage;
    private String productCategory;
    private double productRating;
    private UUID categoryId;
}
