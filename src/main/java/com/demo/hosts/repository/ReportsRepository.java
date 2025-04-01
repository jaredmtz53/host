package com.demo.hosts.repository;

import com.demo.hosts.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportsRepository extends JpaRepository<Reports, Integer> {
}
