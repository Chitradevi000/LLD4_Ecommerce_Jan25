package dev.chitra.EcommerceProductService.controller;

import dev.chitra.EcommerceProductService.client.FakeStoreClient;
import dev.chitra.EcommerceProductService.dto.FakeStoreDto.FakeStoreCartResponseDto;
import dev.chitra.EcommerceProductService.exception.CartNotFoundException;
import dev.chitra.EcommerceProductService.exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    FakeStoreClient fakeStoreClient; //we are directly reaching the client without using the interface(ProductService->FakeStoreProductService)
    //its not a good idea to reach client class directly

    @GetMapping("/cart/{userId}")
    public List<FakeStoreCartResponseDto> getCartByUserId(@PathVariable("userId") int userId) {
        List<FakeStoreCartResponseDto> cartResponseDtos = fakeStoreClient.getCartByUserId(userId);
        if(cartResponseDtos.isEmpty())
        {
            throw new CartNotFoundException("Cart is empty for this UserId" + userId);
        }
        return fakeStoreClient.getCartByUserId(userId);
    }

    @GetMapping("/cartexceptioncheck")
    public ResponseEntity cartExceptionCheck() {
        throw new RandomException("Cart is empty thrown from RandomException");
    }
}
