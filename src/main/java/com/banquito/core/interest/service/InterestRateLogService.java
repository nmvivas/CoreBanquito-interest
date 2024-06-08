package com.banquito.core.interest.service;

import com.banquito.core.interest.model.InterestRateLog;
import com.banquito.core.interest.repository.InterestRateLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestRateLogService {

    private final InterestRateLogRepository repository;

    public InterestRateLogService(InterestRateLogRepository repository) {
        this.repository = repository;
    }

    public List<InterestRateLog> getAllInterestRateLogs() {
        return this.repository.findAll();
    }

    public InterestRateLog getInterestRateLogById(Integer id) {
        Optional<InterestRateLog> interestRateLogOpt = this.repository.findById(id);
        if (interestRateLogOpt.isPresent()) {
            return interestRateLogOpt.get();
        } else {
            throw new RuntimeException("No existe el registro de tasa de interés con ID: " + id);
        }
    }

    public InterestRateLog createInterestRateLog(InterestRateLog interestRateLog) {
        return this.repository.save(interestRateLog);
    }

    public InterestRateLog updateInterestRateLog(Integer id, InterestRateLog interestRateLog) {
        if (this.repository.existsById(id)) {
            return this.repository.save(interestRateLog);
        } else {
            throw new RuntimeException("No existe el registro de tasa de interés con ID: " + id);
        }
    }

    public void deleteInterestRateLog(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new RuntimeException("No existe el registro de tasa de interés con ID: " + id);
        }
    }
}
