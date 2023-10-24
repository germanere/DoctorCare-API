package com.duc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.entity.Patient;
import com.duc.exception.PatientNotFoundException;
import com.duc.repository.PatientRepository;

@Service
@Component("patientservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getPatients(){
		return patientRepository.findAll();
	}

	public void lockAccount(int id) {
		try {
	        Optional<Patient> optionalPatient = patientRepository.findById(id);
	        
	        if (optionalPatient.isPresent()) {
				Patient patient = optionalPatient.get();
				int status =patient.getStatus() == 0 ? 1 : 0;// 0 la khoa , 1 la hoat dong
				patient.setStatus(status);
				if(status ==0) {
					patient.setDescript("tam khoa");
				}else {
					patient.setDescript(null);
				}
				patientRepository.save(patient);
			}else {
		        throw new PatientNotFoundException("Patient not found");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
