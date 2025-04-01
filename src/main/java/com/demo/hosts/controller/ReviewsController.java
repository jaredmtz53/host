package com.demo.hosts.controller;

import com.demo.hosts.model.Renter;
import com.demo.hosts.model.Reviews;
import com.demo.hosts.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

        @Autowired
        private ReviewsRepository reviewsRepository;

    @GetMapping
    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

        // Get review by ID
        @GetMapping("/{reviewID}")
        public Reviews getReview(@PathVariable int reviewID) {
            return reviewsRepository.findById(reviewID).orElse(null);
        }

    // Post
    @PostMapping
    public Reviews createReview(@RequestBody Reviews reviews) {
        return reviewsRepository.save(reviews);
    }

    // Delete
    @DeleteMapping("/{reviewID}")
    public void deleteReview(@PathVariable int reviewID) {
        reviewsRepository.deleteById(reviewID);

    }

    @PutMapping("/{reviewID}")
    public Reviews updateReview(@PathVariable int reviewID, @RequestBody Reviews updateReview) {
        Reviews reviews = reviewsRepository.findById(reviewID).orElseThrow();
        reviews.setReviewer(updateReview.getReviewer());
        reviews.setDescription(updateReview.getDescription());
        reviews.setNumericalRating(updateReview.getNumericalRating());
        return reviewsRepository.save(reviews);

    }
}
