package com.demo.hosts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Booking {
    // add Checkin and checkout
    @Id
    private int confirmationCode;
    private int numberOfGuests;
    private String bookingDate;
    private String bookingTime;
    private String bookingAddress;
    private String bookingCity;
    private String bookingState;
    private String bookingCountry;
    private int bookingZip;
    private String checkInDate;
    private String checkOutDate;

    @ManyToOne
    @JoinColumn(name = "home_owner_id")
    @JsonIgnore
    private HomeOwner homeOwner;

    public Booking() {
    }

    public Booking(int confirmationCode, int numberOfGuests, String bookingDate, String bookingTime, String bookingAddress,
                   String bookingCity, String bookingState, String bookingCountry, int bookingZip,
                   String checkInDate, String checkOutDate, HomeOwner homeOwner) {
        this.confirmationCode = confirmationCode;
        this.numberOfGuests = numberOfGuests;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.bookingAddress = bookingAddress;
        this.bookingCity = bookingCity;
        this.bookingState = bookingState;
        this.bookingCountry = bookingCountry;
        this.bookingZip = bookingZip;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.homeOwner = homeOwner;
    }

    public int getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(int confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingAddress() {
        return bookingAddress;
    }

    public void setBookingAddress(String bookingAddress) {
        this.bookingAddress = bookingAddress;
    }

    public String getBookingCity() {
        return bookingCity;
    }

    public void setBookingCity(String bookingCity) {
        this.bookingCity = bookingCity;
    }

    public String getBookingState() {
        return bookingState;
    }

    public void setBookingState(String bookingState) {
        this.bookingState = bookingState;
    }

    public String getBookingCountry() {
        return bookingCountry;
    }

    public void setBookingCountry(String bookingCountry) {
        this.bookingCountry = bookingCountry;
    }

    public int getBookingZip() {
        return bookingZip;
    }

    public void setBookingZip(int bookingZip) {
        this.bookingZip = bookingZip;
    }
    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public HomeOwner getHomeOwner() {
        return homeOwner;
    }

    public void setHomeOwner(HomeOwner homeOwner) {
        this.homeOwner = homeOwner;
    }
}
