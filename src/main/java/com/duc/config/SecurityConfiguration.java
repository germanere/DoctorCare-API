//package com.duc.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//import lombok.RequiredArgsConstructor;
//
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	  	@Override
//	    public void configure(HttpSecurity http) throws Exception {
//	        http
//	                .csrf()
//	                .disable()
//	                .exceptionHandling()
//	                .and()
//	                .sessionManagement()
//	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	                .and()
//	                .authorizeRequests()
//	                .antMatchers("/public" + "/**").permitAll()
//	                .antMatchers("/admin" + "/**").hasAuthority("admin")
//	                .antMatchers("/api/users/**").hasAnyAuthority("Admin")
//	                .anyRequest()
//	                .authenticated();
//	    }
//
//}
