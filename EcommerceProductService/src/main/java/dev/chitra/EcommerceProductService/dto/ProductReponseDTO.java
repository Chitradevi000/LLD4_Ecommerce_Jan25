package dev.chitra.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class ProductReponseDTO {
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImage;
    private String productCategory;
    private double productRating;
}
