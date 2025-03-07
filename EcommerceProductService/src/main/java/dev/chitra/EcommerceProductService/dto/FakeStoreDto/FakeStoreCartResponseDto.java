package dev.chitra.EcommerceProductService.dto.FakeStoreDto;

import dev.chitra.EcommerceProductService.dto.ProductsListDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartResponseDto {

    private int id;
    private int userId;
    private String productId;
    private List<ProductsListDto> products;
    private int __v;

    /*{
        "id": 1,
            "userId": 1,
            "date": "2020-03-02T00:00:00.000Z",
            "products": [
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
        }
    ],
        "__v": 0
    }*/

    //we are going to create a response DTO for the above data


}
