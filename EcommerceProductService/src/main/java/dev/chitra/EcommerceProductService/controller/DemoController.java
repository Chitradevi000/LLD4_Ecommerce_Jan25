package dev.chitra.EcommerceProductService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("/test")
    public String test() {
        return "Test Successful";
    }
    @GetMapping("/hello")
    public ResponseEntity sayHello() {
        return ResponseEntity.ok("Hello World");
    }

    @DeleteMapping("/deletehello")
    public ResponseEntity deletehello() {
        return ResponseEntity.ok("Hello World deleting");
    }
}
