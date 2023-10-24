package com.duc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.duc.entity.Clinic;

@Repository("clinicrepository")
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
	 @Query(value = "SELECT c.*,s.namepk FROM clinics c \r\n"
	 		+ "INNER JOIN posts p ON p.clinic_Id = c.id\r\n"
	 		+ "inner join specialiazations s on s.id = p.specialization_Id\r\n"
	 		+ "where c.name or c.address or c.price or s.namepk LIKE %:keyword%",nativeQuery = true)
		 List<Clinic> searchResultbyClinics(@Param("keyword") String specialization);
	 
	 Clinic findById(int id);
}
