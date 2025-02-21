package dev.chitra.EcommerceProductService.exception;

import dev.chitra.EcommerceProductService.controller.ProductController;
import dev.chitra.EcommerceProductService.dto.ExceptionReponseDTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ExceptionHandlerApp {
    /*
    we are handling the exceptions for the entire application here
    hence I am having the separate DTO for the response
     */

    // ProductNotFoundException
        @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity handleProductNotFoundException(ProductNotFoundException e) {
            ExceptionReponseDTo exceptionReponseDTo=new ExceptionReponseDTo(404,e.getMessage());
            return new ResponseEntity<>(exceptionReponseDTo, HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException e) {
        ExceptionReponseDTo exceptionReponseDTo=new ExceptionReponseDTo(404,e.getMessage());
        return new ResponseEntity<>(exceptionReponseDTo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RandomException.class)
    private ResponseEntity productRandomException(RandomException ex) {
        ExceptionReponseDTo productRandomResponse = new ExceptionReponseDTo(404,ex.getMessage());
        return new ResponseEntity<>(productRandomResponse,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(CategoryNotFoundException.class)
    private ResponseEntity productCategoryNotFoundException(CategoryNotFoundException ex) {
            ExceptionReponseDTo productCategoryNotFoundResponse = new ExceptionReponseDTo(404,ex.getMessage());
            return new ResponseEntity<>(productCategoryNotFoundResponse,HttpStatus.NOT_FOUND);
    }
}
