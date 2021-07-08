package ru.example.bookdiscount.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.bookdiscount.entity.Discount;
import ru.example.bookdiscount.repository.DiscountRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class DiscountService {
    private final DiscountRepository discountRepository;

    private static final String DISCOUNT_NOT_FOUND_MESSAGE = "Discount with group [code={%s}] not found";

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount getDiscountByGroupCode(String groupCode) {
        var discount= discountRepository.findById(groupCode)
                .orElse(Discount.builder().groupCode(groupCode).discountValue(new BigDecimal(0)).build());
        return discount;
    }

    public List<Discount> getDiscounts() {
        return discountRepository.findAll();
    }


}
