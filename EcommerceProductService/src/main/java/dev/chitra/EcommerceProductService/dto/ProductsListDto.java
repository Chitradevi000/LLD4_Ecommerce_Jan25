package dev.chitra.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsListDto {
    /*"products": [
    {
        "productId": 1,
            "quantity": 4
    },
    {
        "productId": 2,
            "quantity": 1
    },
    {
        "productId": 3,
            "quantity": 6
    }*/

    private int productId;
    private int quantity;
}
