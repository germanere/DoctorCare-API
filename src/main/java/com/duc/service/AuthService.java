package com.duc.service;

import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.duc.dto.LoginDto;
import com.duc.entity.User;
import com.duc.exception.InvalidCredentialsException;
import com.duc.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Component("authservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class AuthService {

	
		@Autowired
		private UserRepository userRepository;
	
		@Value("${app.jwtSecret}")  
		private String jwtSecret;
		
		@Value("${app.jwtExpirationInMs}") 
		private int jwtExpirationInMs;
		
		@Autowired
		private JwtServiceImplement jwtServiceImplement;
	
	public String login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        
        User user = userRepository.findByEmail(email);
        if (user == null || !password.equals(user.getPassword())) {
            throw new InvalidCredentialsException("Email hoặc mật khẩu không chính xác");
        }
        
        // Tạo JWT token
        String token = jwtServiceImplement.genToken(user);
//        if(isTokenAuthorized(token)) {
            return token;
//        }
	}
	

    
}


