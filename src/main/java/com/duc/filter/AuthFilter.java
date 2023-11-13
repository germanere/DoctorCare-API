package com.duc.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.duc.service.JwtServiceImplement;

@Component
@ComponentScan(basePackages = {"com.duc.filter"})
public class AuthFilter implements Filter {	
	@Autowired
	private JwtServiceImplement jwtServiceImplement;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String requestURI = httpServletRequest.getRequestURI();
		String method = httpServletRequest.getMethod();
		String token = httpServletRequest.getHeader("Authorization");
		if (requestURI.contains("/login")||requestURI.contains("/forgot-password")||requestURI.contains("/reset-password")||requestURI.contains("/register")) {
			chain.doFilter(request, response);
			}
		else {
			jwtServiceImplement.parseToken(token);
			if (!jwtServiceImplement.getAuthentication(token, requestURI)) {
				System.out.println("Khong co role");
				throw new ServletException();
			}
		}
		chain.doFilter(request, response);
	}
	

}
