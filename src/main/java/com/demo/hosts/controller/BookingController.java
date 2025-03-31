package com.demo.hosts.controller;

import com.demo.hosts.model.Booking;
import com.demo.hosts.model.HomeOwner;
import com.demo.hosts.repository.BookingRepository;
import com.demo.hosts.repository.HomeOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HomeOwnerRepository homeOwnerRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{confirmationCode}")
    public Booking getBookingByCode(@PathVariable int confirmationCode) {
        return bookingRepository.findById(confirmationCode).orElse(null);
    }

    @PostMapping("/{homeOwnerId}")
    public Booking createBooking(@PathVariable int homeOwnerId, @RequestBody Booking booking) {
        HomeOwner owner = homeOwnerRepository.findById(homeOwnerId).orElse(null);
        if (owner != null) {
            booking.setHomeOwner(owner);
            return bookingRepository.save(booking);
        }
        return null;
    }

    @PutMapping("/{confirmationCode}")
    public Booking updateBooking(@PathVariable int confirmationCode, @RequestBody Booking updatedBooking) {
        return bookingRepository.findById(confirmationCode).map(existingBooking -> {
            existingBooking.setNumberOfGuests(updatedBooking.getNumberOfGuests());
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            existingBooking.setBookingTime(updatedBooking.getBookingTime());
            existingBooking.setBookingAddress(updatedBooking.getBookingAddress());
            existingBooking.setBookingCity(updatedBooking.getBookingCity());
            existingBooking.setBookingState(updatedBooking.getBookingState());
            existingBooking.setBookingCountry(updatedBooking.getBookingCountry());
            existingBooking.setBookingZip(updatedBooking.getBookingZip());
            existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
            existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
            existingBooking.setHomeOwner(updatedBooking.getHomeOwner());
            return bookingRepository.save(existingBooking);
        }).orElse(null);
    }

    @DeleteMapping("/{confirmationCode}")
    public void deleteBooking(@PathVariable int confirmationCode) {
        bookingRepository.deleteById(confirmationCode);
    }
}