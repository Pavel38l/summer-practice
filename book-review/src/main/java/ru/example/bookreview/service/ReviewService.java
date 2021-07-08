package ru.example.bookreview.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import ru.example.bookreview.dto.ReviewDto;
import ru.example.bookreview.dto.UserDto;
import ru.example.bookreview.entity.Review;
import ru.example.bookreview.repository.ReviewRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Burdyug Pavel
 */
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    private static final String REVIEW_NOT_FOUND_MESSAGE = "Review [ID={%d}] not found";

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserService userService, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public Review getReview(Long id) {
        final var review = reviewRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        REVIEW_NOT_FOUND_MESSAGE,
                        id
                )));
        return review;
    }

    public List<ReviewDto> getReviewsByBookId(Long bookId) {
        return reviewRepository.findAllByBookId(bookId).stream().map(review -> {
            ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
            try {
                reviewDto.setUserDto(userService.getUser(review.getId()));
            } catch (RestClientException ex) {
                reviewDto.setUserDto(UserDto.builder().id(review.getUserId()).build());
            }

            return reviewDto;
        }).collect(Collectors.toList());
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
