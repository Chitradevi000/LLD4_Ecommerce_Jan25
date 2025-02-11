package dev.chitra.EcommerceProductService.exception;

import dev.chitra.EcommerceProductService.controller.CartController;
import dev.chitra.EcommerceProductService.dto.ExceptionReponseDTo;
import dev.chitra.EcommerceProductService.dto.FakeStoreCartResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class ExceptionHandlerCartController {

    @ExceptionHandler(CartNotFoundException.class)
    private ResponseEntity handleCartNotFoundException(CartNotFoundException ex) {
        ExceptionReponseDTo fakeStoreCartResponseDto = new ExceptionReponseDTo(404,ex.getMessage());
        return new ResponseEntity<>(fakeStoreCartResponseDto,HttpStatus.NOT_FOUND);
    }
}
