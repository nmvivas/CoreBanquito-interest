package com.banquito.core.interest.controller;

import com.banquito.core.interest.model.InterestRate;
import com.banquito.core.interest.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/interest-rates")
public class InterestRateController {

    @Autowired
    private InterestRateService interestRateService;

    @GetMapping
    public ResponseEntity<List<InterestRate>> getAllInterestRates() {
        return ResponseEntity.ok(this.interestRateService.getAllInterestRates());
    }

    @GetMapping("/{code}")
    public ResponseEntity<InterestRate> getInterestRateByCode(@PathVariable String code) {
        try {
            return ResponseEntity.ok(this.interestRateService.getInterestRateByCode(code));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InterestRate> createInterestRate(@RequestBody InterestRate interestRate) {
        return ResponseEntity.ok(this.interestRateService.createInterestRate(interestRate));
    }

    @PutMapping("/{code}")
    public ResponseEntity<InterestRate> updateInterestRate(@PathVariable String code,
            @RequestBody InterestRate interestRate) {
        return ResponseEntity.ok(this.interestRateService.updateInterestRate(code, interestRate));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteInterestRate(@PathVariable String code) {
        this.interestRateService.deleteInterestRate(code);
        return ResponseEntity.noContent().build();
    }
}
