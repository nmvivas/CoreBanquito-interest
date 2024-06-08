package com.banquito.core.interest.repository;

import com.banquito.core.interest.model.InterestRate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRateRepository extends JpaRepository<InterestRate, String> {

}
