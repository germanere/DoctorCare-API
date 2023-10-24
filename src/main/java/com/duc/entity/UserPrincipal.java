//package com.duc.entity;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//public class UserPrincipal implements UserDetails {
//	private static final long serialVersionUID = 1L;
//	private int id;
//	@JsonIgnore
//	private String email;
//	@JsonIgnore
//	private String password;
//	
//	private Collection<? extends GrantedAuthority> authorities;
//
//	public UserPrincipal(int id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.authorities = authorities;
//	}
//
//	public static UserPrincipal create(User user)  {
//		Set<Role> roles = (Set<Role>) user.getRole();
//		List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//		
//		return new UserPrincipal(user.getId(), user.getEmail(), user.getPassword(), authorities);
//	}
//
//}
