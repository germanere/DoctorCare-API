package com.duc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.duc.entity.DoctorUser;

public interface DoctorUserRepository extends JpaRepository<DoctorUser, Integer>{

}
