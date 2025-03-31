package com.demo.hosts.controller;

import com.demo.hosts.model.Booking;
import com.demo.hosts.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{confirmationCode}")
    public Booking getBookingByCode(@PathVariable int confirmationCode) {
        return bookingRepository.findById(confirmationCode).orElse(null);
    }
}