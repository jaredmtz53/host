package com.demo.hosts.controller;

import com.demo.hosts.model.Houses;
import com.demo.hosts.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/houses")
public class HousesController {

    @Autowired
    private HousesRepository housesRepository;

    @GetMapping
    public List<Houses> getAllHouses() {
        return housesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Houses> getHouseById(@PathVariable int id) {
        return housesRepository.findById(id);
    }

    @PostMapping
    public Houses createHouse(@RequestBody Houses house) {
        return housesRepository.save(house);
    }

    @PutMapping("/{id}")
    public Houses updateHouse(@PathVariable int id, @RequestBody Houses houseDetails) {
        Houses house = housesRepository.findById(id).orElseThrow();
        house.setAddress(houseDetails.getAddress());
        house.setOwnerName(houseDetails.getOwnerName());
        house.setBedRooms(houseDetails.getBedRooms());
        house.setBathrooms(houseDetails.getBathrooms());
        house.setPricePerNight(houseDetails.getPricePerNight());
        return housesRepository.save(house);
    }

    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable int id) {
        housesRepository.deleteById(id);
    }
}