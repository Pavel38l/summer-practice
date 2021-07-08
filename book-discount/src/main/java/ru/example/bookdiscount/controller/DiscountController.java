package ru.example.bookdiscount.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookdiscount.entity.Discount;
import ru.example.bookdiscount.service.DiscountService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Slf4j
public class DiscountController {
    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/discount")
    public List<Discount> getDiscounts() {
        return discountService.getDiscounts();
    }

    @GetMapping("/discount/{groupCode}")
    public ResponseEntity<BigDecimal> getDiscount(@PathVariable String groupCode) {
        log.info("User requested discount with group code: {} ", groupCode);
        var discount = discountService.getDiscountByGroupCode(groupCode);
        return new ResponseEntity<>(discount.getDiscountValue(), HttpStatus.OK);
    }

}
