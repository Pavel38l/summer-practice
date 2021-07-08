package ru.example.bookreview.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookreview.dto.ReviewDto;
import ru.example.bookreview.entity.Review;
import ru.example.bookreview.service.ReviewService;

import java.util.List;

/**
 * @author Burdyug Pavel
 */

@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        log.info("User requested review: {} ", id);
        return reviewService.getReview(id);
    }

    @GetMapping("/book/{bookId}")
    public List<ReviewDto> getReviewsByBookId(@PathVariable Long bookId) {
        log.info("User requested reviews on book: {} ", bookId);
        return reviewService.getReviewsByBookId(bookId);
    }

    @GetMapping("")
    public List<Review> getALlReviews() {
        return reviewService.getAllReviews();
    }
}
