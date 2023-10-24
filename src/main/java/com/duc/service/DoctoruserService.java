package com.duc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.entity.DoctorUser;
import com.duc.repository.DoctorUserRepository;

@Service
@Component("doctorservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class DoctoruserService {
	@Autowired
	private DoctorUserRepository doctorUserRepository;
	
	public void savedoctor(DoctorUser doctorUser) {
		doctorUserRepository.save(doctorUser);
	}
	
	public void unlockandlockdoctorAccount(int id) {
		try {
	        Optional<DoctorUser> optionalDoctor = doctorUserRepository.findById(id);
	        
	        if (optionalDoctor.isPresent()) {
				DoctorUser doctorUser = optionalDoctor.get();
				int status =doctorUser.getStatus() == 0 ? 1 : 0; // 0 la khoa , 1 la hoat dong
				doctorUser.setStatus(status);
				if(status ==0) {
					doctorUser.setDescript("tam khoa");
				}else {
					doctorUser.setDescript(null);
				}
				doctorUserRepository.save(doctorUser);
			}else {
		       System.out.println("Doctor Not FOUND !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
