package com.duc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.entity.Schedule;
import com.duc.repository.ScheduleReposiroty;

@Service
@Component("scheduleservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class SchelduleService {
	
	@Autowired
	private ScheduleReposiroty scheduleReposiroty;
	
	public void saveschedule(Schedule schedule) {
		scheduleReposiroty.save(schedule);
	}
	public void cancelandreceive(int id) {

			Optional<Schedule> scheduleOptional = scheduleReposiroty.findById(id);
			
			if(scheduleOptional.isPresent()) {
				Schedule schedule= scheduleOptional.get();
				schedule.getStatus();
			}	
		
	}
}
