package com.demo.hosts.repository;

import com.demo.hosts.model.Houses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousesRepository extends JpaRepository<Houses, Integer> {
}