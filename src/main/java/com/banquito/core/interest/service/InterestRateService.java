package com.banquito.core.interest.service;

import com.banquito.core.interest.model.InterestRate;
import com.banquito.core.interest.repository.InterestRateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestRateService {

    private final InterestRateRepository repository;

    public InterestRateService(InterestRateRepository repository) {
        this.repository = repository;
    }

    public List<InterestRate> getAllInterestRates() {
        return this.repository.findAll();
    }

    public InterestRate getInterestRateByCode(String code) {
        Optional<InterestRate> interestRateOpt = this.repository.findById(code);
        if (interestRateOpt.isPresent()) {
            return interestRateOpt.get();
        } else {
            throw new RuntimeException("No existe la tasa de interés con código: " + code);
        }
    }

    public InterestRate createInterestRate(InterestRate interestRate) {
        return this.repository.save(interestRate);
    }

    public InterestRate updateInterestRate(String code, InterestRate interestRate) {
        if (this.repository.existsById(code)) {
            return this.repository.save(interestRate);
        } else {
            throw new RuntimeException("No existe la tasa de interés con código: " + code);
        }
    }

    public void deleteInterestRate(String code) {
        if (this.repository.existsById(code)) {
            this.repository.deleteById(code);
        } else {
            throw new RuntimeException("No existe la tasa de interés con código: " + code);
        }
    }
}
