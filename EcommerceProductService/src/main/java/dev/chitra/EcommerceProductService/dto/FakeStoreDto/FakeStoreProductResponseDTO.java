package dev.chitra.EcommerceProductService.dto.FakeStoreDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@Getter
@Setter
public class FakeStoreProductResponseDTO implements Serializable {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private FakeStoreProductRatingDTO fakeStoreProductRatingDTO;

}
