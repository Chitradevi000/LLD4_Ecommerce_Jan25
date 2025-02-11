package dev.chitra.EcommerceProductService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionReponseDTo {
    public int errorCode;
    private String message;

}
