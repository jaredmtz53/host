package com.demo.hosts.controller;

import com.demo.hosts.model.Renter;
import com.demo.hosts.model.Reports;
import com.demo.hosts.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private ReportsRepository reportsRepository;

    @GetMapping
    public List<Reports> getAllReports() {
        return reportsRepository.findAll();
    }

    // Get report by ID
    @GetMapping("/{reportID}")
    public Reports getReport(@PathVariable int reportID) {
        return reportsRepository.findById(reportID).orElse(null);
    }


    // Post
    @PostMapping
    public Reports createReport(@RequestBody Reports reports) {
        return reportsRepository.save(reports);
    }

    // Delete
    @DeleteMapping("/{reportID}")
    public void deleteReport(@PathVariable int reportID) {
        reportsRepository.deleteById(reportID);

    }

    @PutMapping("/{reportID}")
    public Reports updateReport(@PathVariable int reportID, @RequestBody Reports updateReport) {
        Reports reports = reportsRepository.findById(reportID).orElseThrow();
        reports.setReportType(updateReport.getReportType());
        reports.setReason(updateReport.getReason());
        return reportsRepository.save(reports);

    }
    }





