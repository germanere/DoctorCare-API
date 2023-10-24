package com.duc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duc.entity.Specialization;

@Repository("specialiazationrepository")
public interface SpecialiazationRepository extends JpaRepository<Specialization, Integer>{

}
