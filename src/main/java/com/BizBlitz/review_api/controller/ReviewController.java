package com.BizBlitz.review_api.controller;

import com.BizBlitz.review_api.model.ReviewEntity;
import com.BizBlitz.review_api.model.ReviewRequest;
import com.BizBlitz.review_api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewEntity> createReview(@RequestBody ReviewRequest reviewRequest) {
        ReviewEntity review = reviewService.createReview(
                reviewRequest.getUserId(),
                reviewRequest.getBusinessId(),
                reviewRequest.getReviewText(),
                reviewRequest.getRating());
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewEntity>> getReviewsByUserId(@PathVariable Long userId) {
        List<ReviewEntity> reviews = reviewService.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<ReviewEntity> getReviewById(@PathVariable UUID reviewId) {
        ReviewEntity review = reviewService.getReviewById(reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping("/business/{businessId}")
    public ResponseEntity<List<ReviewEntity>> getReviewsByBusinessId(@PathVariable String businessId) {
        List<ReviewEntity> reviews = reviewService.getReviewsByBusinessId(businessId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewEntity> updateReview(@PathVariable UUID reviewId,
                                                     @RequestBody ReviewRequest reviewRequest) {
        ReviewEntity updatedReview = reviewService.updateReview(
                reviewId,
                reviewRequest.getReviewText(),
                reviewRequest.getRating()
        );
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
