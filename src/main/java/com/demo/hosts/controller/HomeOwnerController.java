package com.demo.hosts.controller;

import com.demo.hosts.model.HomeOwner;
import com.demo.hosts.repository.HomeOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homeowners")
public class HomeOwnerController {

    @Autowired
    private HomeOwnerRepository homeOwnerRepository;

    @GetMapping
    public List<HomeOwner> getAllHomeOwners() {
        return homeOwnerRepository.findAll();
    }

    @PostMapping
    public HomeOwner createHomeOwner(@RequestBody HomeOwner homeOwner) {
        return homeOwnerRepository.save(homeOwner);
    }

    @GetMapping("/{id}")
    public HomeOwner getHomeOwner(@PathVariable int id) {
        return homeOwnerRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public HomeOwner updateHomeOwner(@PathVariable int id, @RequestBody HomeOwner updatedOwner) {
        return homeOwnerRepository.findById(id).map(owner -> {
            owner.setName(updatedOwner.getName());
            owner.setEmail(updatedOwner.getEmail());
            return homeOwnerRepository.save(owner);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteHomeOwner(@PathVariable int id) {
        homeOwnerRepository.deleteById(id);
    }
}


