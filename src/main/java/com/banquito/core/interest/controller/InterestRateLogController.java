package com.banquito.core.interest.controller;

import com.banquito.core.interest.model.InterestRateLog;
import com.banquito.core.interest.service.InterestRateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT })
@RestController
@RequestMapping(path = "/interest-rate-logs")
public class InterestRateLogController {

    @Autowired
    private InterestRateLogService interestRateLogService;

    @GetMapping
    public ResponseEntity<List<InterestRateLog>> getAllInterestRateLogs() {
        return ResponseEntity.ok(this.interestRateLogService.getAllInterestRateLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterestRateLog> getInterestRateLogById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.interestRateLogService.getInterestRateLogById(id));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InterestRateLog> createInterestRateLog(@RequestBody InterestRateLog interestRateLog) {
        return ResponseEntity.ok(this.interestRateLogService.createInterestRateLog(interestRateLog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterestRateLog> updateInterestRateLog(@PathVariable Integer id,
            @RequestBody InterestRateLog interestRateLog) {
        return ResponseEntity.ok(this.interestRateLogService.updateInterestRateLog(id, interestRateLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterestRateLog(@PathVariable Integer id) {
        this.interestRateLogService.deleteInterestRateLog(id);
        return ResponseEntity.noContent().build();
    }
}
