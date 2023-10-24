package com.duc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duc.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
