package ru.example.bookdiscount.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Burdyug Pavel
 */

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    private String groupCode;
    private BigDecimal discountValue;
}
