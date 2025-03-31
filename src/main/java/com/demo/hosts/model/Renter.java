package com.demo.hosts.model;

import jakarta.persistence.*;

@Entity
    public class Renter {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int renterID;

        @Column(nullable = false)
        private int payment;
        private int paymentMethod;

        // Constructors
        public Renter() {}
        public Renter(int renterID, int payment, int paymentMethod) {
            this.renterID = renterID;
            this.payment = payment;
            this.paymentMethod = paymentMethod;
        }

        // Getters

        public int getRenterID() {
            return renterID;
        }

        public int getPayment() {
            return payment;
        }

        public int getPaymentMethod() {
            return paymentMethod;
        }

        // Setters

        public void setRenterID(int renterID) {
            this.renterID = renterID;
        }

        public void setPayment(int payment) {
            this.payment = payment;
        }

        public void setPaymentMethod(int paymentMethod) {
            this.paymentMethod = paymentMethod;
        }
    }

