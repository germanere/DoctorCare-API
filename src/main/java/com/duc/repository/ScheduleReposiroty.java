package com.duc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duc.entity.Schedule;

@Repository("schedulerepository")
public interface ScheduleReposiroty extends JpaRepository<Schedule, Integer> {

}
