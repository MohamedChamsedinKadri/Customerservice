package com.example.customerservice.repository;

import com.example.customerservice.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByRating (int rating);

}
