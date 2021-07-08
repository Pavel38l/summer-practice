package ru.example.bookstore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class DiscountService {

    @Value("${discount-url}")
    private String DISCOUNT_URL;

    public BigDecimal getDiscount(String groupCode) {
        try {
            ResponseEntity<BigDecimal> responseEntity = new RestTemplate().getForEntity
                    (String.format("%s/%s", DISCOUNT_URL, groupCode), BigDecimal.class);
            return responseEntity.getBody();
        }
        catch (RestClientException ex) {
            return new BigDecimal(0);
        }
    }
}
