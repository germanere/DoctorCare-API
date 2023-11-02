package com.duc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duc.dto.ClinicsDto;
import com.duc.dto.PatientDTO;
import com.duc.dto.SpecializationDto;
import com.duc.entity.Clinic;
import com.duc.entity.Patient;
import com.duc.entity.Schedule;
import com.duc.entity.Specialization;
import com.duc.exception.PatientNotFoundException;
import com.duc.repository.ScheduleReposiroty;
import com.duc.service.ClinicService;
import com.duc.service.DoctoruserService;
import com.duc.service.PatientService;
import com.duc.service.SpecialiazationService;

@RestController
@RequestMapping("/api")
public class AppController {
	@Autowired
	private ScheduleReposiroty scheduleReposiroty;
	
	@Autowired
	private DoctoruserService doctoruserService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private SpecialiazationService specialiazationService;
	
	@GetMapping
	public String sayHello() {
		return "hello you :))";
	}
	
	@GetMapping("/users/specialiazations")
	public List<SpecializationDto> Specialiazations() {
		List<Specialization>pSpecializationDtos = specialiazationService.getSpecializations();
		
		List<SpecializationDto> specializationDtos = new ArrayList<>();
		
		for(Specialization specialization : pSpecializationDtos) {
			specializationDtos.add(new SpecializationDto(specialization.getId(),specialization.getName(),specialization.getDescription()));
		}
		return specializationDtos;
	}
	
	@GetMapping("/users/clinics")
	public List<ClinicsDto> Clinics(){
		List<Clinic>clinics = clinicService.getcClinics();
		
		List<ClinicsDto> clinicsDtos = new ArrayList<>();
		
		for(Clinic clinic : clinics) {
			clinicsDtos.add(new ClinicsDto(clinic.getAddress(), clinic.getDescription(), clinic.getName(), clinic.getPhone(),clinic.getPrice()));
		}
		return clinicsDtos;
	}
	
	@GetMapping("/doctor/patients")
	public List<PatientDTO> patientDTOs(){
		List<Patient> patients = patientService.getPatients();
		
		List<PatientDTO> patientDTOs = new ArrayList<>();
		
		for(Patient patient : patients) {
			patientDTOs.add(new PatientDTO(patient.getUsers().getName(),patient.getUsers().getGender(),patient.getUsers().getAddress(), patient.getPathology(), patient.getPathologydetail()));
		}
		return patientDTOs;
	}
	
	@PostMapping("/admin/patient/{id}/unlockorlock")
	public ResponseEntity<String> lockAccount(@PathVariable int id) {
        try {
            patientService.lockAccount(id);
            return ResponseEntity.ok("Patient account was changed status successfully.");
        } catch (PatientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
	@PostMapping("/admin/doctor/{id}/unlockorlock")
	public ResponseEntity<String> lockDoctorAccount(@PathVariable int id) {
        try {
            doctoruserService.unlockandlockdoctorAccount(id);
            return ResponseEntity.ok("Doctor account was changed status successfully.");
        } catch (PatientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found.");
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
	
	@PostMapping("/doctor/schedules/{id}/Received-or-Cancel-schedules")
	public ResponseEntity<String> receiandcancelschel(@PathVariable int id){
		try {
			Optional<Schedule> scheduleOptional = scheduleReposiroty.findById(id);
			
			if(scheduleOptional.isPresent()) {
				Schedule schedule= scheduleOptional.get();
				if(schedule.getStatus()==2) {
					schedule.setDescript(null);
					return ResponseEntity.ok("Schedule was reiceved successfully.");
				}else if(schedule.getStatus()==3) {
					schedule.setDescript("Cancel");
					scheduleReposiroty.save(schedule);
					return ResponseEntity.ok("Schedule was canceled successfully.");
				}
			}
			return ResponseEntity.ok("Schedule was changed status successfully.");
		} catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
		}
	}
	
	@GetMapping("/admin/schedules/patient/{id}")
	public ResponseEntity<String> detailschedulesPatient(@PathVariable int id){
		try {
			patientService.getPatient(id);
			return ResponseEntity.ok("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
