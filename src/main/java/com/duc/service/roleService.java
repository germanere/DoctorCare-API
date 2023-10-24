package com.duc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.duc.entity.Role;
import com.duc.repository.RoleRepository;

@Service
@Component("roleservice")
public class roleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRole(int roleId) {
		List<Role> roles =roleRepository.findAll();
        for (Role role : roles) {
        	if(role.getId()==roleId)
        		return role;
        }
		return null;
	}
}
