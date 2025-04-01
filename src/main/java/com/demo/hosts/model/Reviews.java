package com.demo.hosts.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewID;

    @Column(nullable = false)
    private String reviewer;
    private String description;
    private int numericalRating;
    private LocalDateTime reviewCreatedAt;

    // Constructors
    public Reviews() {
    }

    public Reviews(int reviewID, String reviewer, String description, int numericalRating, LocalDateTime reviewCreatedAt) {
        this.reviewID = reviewID;
        this.reviewer = reviewer;
        this.description = description;
        this.numericalRating = numericalRating;
        this.reviewCreatedAt = reviewCreatedAt;
    }

    // Getters and Setters
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumericalRating() {
        return numericalRating;
    }

    public void setNumericalRating(int numericalRating) {
        this.numericalRating = numericalRating;
    }

    public LocalDateTime getReviewCreatedAt() {
        return reviewCreatedAt;
    }

    public void setReviewCreatedAt(LocalDateTime reviewCreatedAt) {
        this.reviewCreatedAt = reviewCreatedAt;
    }
}