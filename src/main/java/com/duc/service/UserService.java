package com.duc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duc.dto.SearchDocterDto;
import com.duc.entity.User;
import com.duc.repository.UserRepository;

@Service
@Component("userservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@Transactional
	public  boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
    }
	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}
	@Transactional
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Transactional
	public User FindUserById(int id) {
		return userRepository.findById(id);
	 
	}
	public User findbynameUser(String name) {
		return userRepository.findbynameUser(name);
	}
	
	public List<SearchDocterDto> seaUsers(String keyword){
		if(keyword!=null) {
			System.out.println("keyword: " + keyword);
			List<User> users= userRepository.searchDoctorsBySpecialization(keyword);
			
			List<SearchDocterDto> DocterDtos = new ArrayList<>();
			for(User user: users) {
				DocterDtos.add(new SearchDocterDto(user.getId(), user.getName(),user.getPosts().get(0).getSpecialization().getName()));
			}
			return DocterDtos;
		}
		return null;
	}
}
