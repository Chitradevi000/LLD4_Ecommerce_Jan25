package dev.chitra.EcommerceProductService.exception;

import java.io.Serializable;

public class ProductNotFoundException extends RuntimeException implements Serializable {

    public ProductNotFoundException(String message) {
        super(message);
    }

}
