package com.demo.hosts.repository;

import com.demo.hosts.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RenterRepository extends JpaRepository<Renter, Integer> {

}