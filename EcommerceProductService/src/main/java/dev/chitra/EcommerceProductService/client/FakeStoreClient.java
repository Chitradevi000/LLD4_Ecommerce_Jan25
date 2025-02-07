package dev.chitra.EcommerceProductService.client;

import dev.chitra.EcommerceProductService.dto.FakeStoreProductRatingDTO;
import dev.chitra.EcommerceProductService.dto.FakeStoreProductResponseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

/*
this class will create a fakestore URL which is a constant
things which we can store in App.properties*/
@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") //this annotation will fetch the value from app.properties and share her
    private String fakeStoreBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStorePath;


    public List<FakeStoreProductResponseDTO> getAllProducts()
    {
        String url = fakeStoreBaseUrl.concat(fakeStorePath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productsResponseList = restTemplate.getForEntity(url, FakeStoreProductResponseDTO[].class);
        return List.of(Objects.requireNonNull(productsResponseList.getBody()));
    }
}
