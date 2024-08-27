package com.BizBlitz.review_api.repository;

import com.BizBlitz.review_api.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByUserId(Long userId);
    List<ReviewEntity> findByBusinessId(String businessId);

    ReviewEntity findById(UUID id);

    void deleteById(UUID reviewId);
}
