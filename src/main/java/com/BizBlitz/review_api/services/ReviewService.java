package com.BizBlitz.review_api.services;

import com.BizBlitz.review_api.model.ReviewEntity;
import com.BizBlitz.review_api.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewEntity createReview(Long userId, String businessId, String reviewText, int rating) {
        ReviewEntity review = new ReviewEntity();
        review.setId(UUID.randomUUID());
        review.setUserId(userId);
        review.setBusinessId(businessId);
        review.setReviewText(reviewText);
        review.setRating(rating);
        review.setCreateAt(new Timestamp(System.currentTimeMillis()));
        review.setEdited(false);

        return reviewRepository.save(review);
    }

    public List<ReviewEntity> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public List<ReviewEntity> getReviewsByBusinessId(String businessId) {
        return reviewRepository.findByBusinessId(businessId);
    }

    public ReviewEntity getReviewById(UUID reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public ReviewEntity updateReview(UUID reviewId, String reviewText, int rating) {
        ReviewEntity review = getReviewById(reviewId);
        review.setReviewText(reviewText);
        review.setRating(rating);
        review.setEdited(true);
        return reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(UUID reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId);

        reviewRepository.delete(review);
    }
}
