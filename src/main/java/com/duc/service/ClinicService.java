package com.duc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.dto.SearchResultDto;
import com.duc.entity.Clinic;
import com.duc.repository.ClinicRepository;

@Service
@Component("clinicservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	
	public List<Clinic> getcClinics(){
		return clinicRepository.findAll();
	}
	
	public List<SearchResultDto> searesult(String keyword){
	if(keyword!=null) {
		List <Clinic> clinics = clinicRepository.searchResultbyClinics(keyword);
		
		List <SearchResultDto> searchResultDtos = new ArrayList<>();
		for(Clinic clinic : clinics) {
			searchResultDtos.add(new SearchResultDto(clinic.getId(), clinic.getName(),clinic.getAddress(),clinic.getPrice(),clinic.getPost().getSpecialization().getName()));
		}
		return searchResultDtos;
	}
		return null;
	}
	
	public Clinic Findclinicbyid(int id) {
		return clinicRepository.findById(id);
	}
	
}
