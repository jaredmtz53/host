package com.demo.hosts.repository;

import com.demo.hosts.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer>  {
}
