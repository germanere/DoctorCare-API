package com.duc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.duc.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	
	 boolean existsByEmail(String email);
	 
	 User findByEmail(String email);
	 
	 User findById(int id);
	 
	 @Query(value = "SELECT u.* FROM users u\r\n"
	 		+ "INNER JOIN posts p ON p.user_Id = u.id\r\n"
	 		+ "INNER JOIN specialiazations s ON s.id = p.specialization_Id\r\n"
	 		+ "WHERE s.name LIKE %:keyword%",nativeQuery = true)
	 List<User> searchDoctorsBySpecialization(@Param("keyword") String specialization);
	 
	 @Query(value = "SELECT u.name FROM users u\r\n"
	 		+ "inner join roles r on r.id = u.role_id\r\n"
	 		+ "where u.name like %:name% and r.id=1;",nativeQuery = true)
	 User findbynameUser(String name);
}
