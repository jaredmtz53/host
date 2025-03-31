// HomeOwnerRepository.java
package com.demo.hosts.repository;

import com.demo.hosts.model.HomeOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeOwnerRepository extends JpaRepository<HomeOwner, Integer> {
}