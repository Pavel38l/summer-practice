package ru.example.bookdiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookdiscount.entity.Discount;


@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {
}
