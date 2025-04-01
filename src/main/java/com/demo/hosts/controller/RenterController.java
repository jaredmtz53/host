package com.demo.hosts.controller;
import com.demo.hosts.model.Booking;
import com.demo.hosts.model.Renter;
import com.demo.hosts.repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/renters")
public class RenterController {

        @Autowired
        private RenterRepository renterRepository;

        @GetMapping
        public List<Renter> getAllRenters() {
        return renterRepository.findAll();
        }

        // Get renter by ID
        @GetMapping("/{renterID}")
        public Renter getRenter(@PathVariable int renterID) {
            return renterRepository.findById(renterID).orElse(null);
        }

        // Post
        @PostMapping
        public Renter createRenter(@RequestBody Renter renter) {
            if (renter.getRenterID() != 0 && renterRepository.existsById(renter.getRenterID())) {
                throw new IllegalArgumentException("Renter with ID already exists. Use PUT to update.");
            }
            return renterRepository.save(renter);
        }

        // Delete
        @DeleteMapping("/{renterID}")
        public void deleteRenter(@PathVariable int renterID) {
            renterRepository.deleteById(renterID);

        }

        @PutMapping("/{renterID}")
        public Renter updateRenter(@PathVariable int renterID, @RequestBody Renter updateRenter) {
            Renter renter = renterRepository.findById(renterID).orElseThrow();
            renter.setPayment(updateRenter.getPayment());
            renter.setPaymentMethod(updateRenter.getPaymentMethod());
            return renterRepository.save(renter);
        }
}
