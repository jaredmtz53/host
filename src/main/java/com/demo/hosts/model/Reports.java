package com.demo.hosts.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reports {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int reportID;
        @Column(nullable = false)
        private String reportType;
        private String reason;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        // Constructors
        public Reports() {}
        public Reports(int reportID, String reportType, String reason, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.reportID = reportID;
            this.reportType = reportType;
            this.reason= reason;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        // Getters
        public int getReportID() { return reportID; }
        public String getReportType() { return reportType; }
        public String getReason() { return reason; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public LocalDateTime getUpdatedAt() {return updatedAt;}

        // Setters
        public void setReportID(int reportID) { this.reportID = reportID;}
        public void setReportType(String reportType) {this.reportType = reportType;}
        public void setReason(String reason) {this.reason = reason;}
        public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
        public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

        // Automatically set createdAt before inserting a new report
        @PrePersist
        public void prePersist() {
            this.createdAt = LocalDateTime.now(); // Set createdAt to current time
            this.updatedAt = LocalDateTime.now(); // Set updatedAt to current time
        }

        // Automatically set updatedAt before updating a report
        @PreUpdate
        public void preUpdate() {
            this.updatedAt = LocalDateTime.now(); // Set updatedAt to current time
        }
    }


