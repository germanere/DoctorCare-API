package com.duc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.entity.Specialization;
import com.duc.repository.SpecialiazationRepository;

@Service
@Component("specialiazationservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class SpecialiazationService {

	@Autowired
	private SpecialiazationRepository specialiazationRepository;
	
	public List<Specialization> getSpecializations(){
		return specialiazationRepository.findAll();
	}
}
