package com.duc.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.duc.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

//import org.springframework.security.core.authority.SimpleGrantedAuthority;
@Service
public class JwtServiceImplement {
	 private Key key;

	    private JwtParser jwtParser;
	    private String jwtBase64Secret = "ZDdlZTJkNTViMWJiMzA3OTFmMThhNGU5MTZiNzMwMmNhMGQyZjUwMzcwZWMwZThiNTYwN2FiMmEwNDNhMDkxNmMzMjBkMmMzNmRlYjM1YzhkYzJmZDU0YjU1YWMxNzZmOTY0ZjA3MmMyZTkxNzI5MjY1MTc4ODQ5YWJhNTY0YzQ=";
	    private static final String AUTHORITIES_KEY = "auth";

	    @PostConstruct
	    public void setup() {
	        byte[] keyBytes = Decoders.BASE64.decode(jwtBase64Secret);
	        key = Keys.hmacShaKeyFor(keyBytes);
	        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
	    }

	    public String genToken(User user) {
	        return "token: " +
	                Jwts.builder()
	                    .setHeaderParam("typ","JWT")
	                    .setIssuer("ducnguyen")
	                    .setSubject(user.getEmail())
	                    .setAudience("Loyalty")
	                    .setExpiration(new Date((new Date()).getTime() + 2*60*1000L))
	                    .setNotBefore(new Date())
	                    .setIssuedAt(new Date())
	                    .setId(user.getId() + "")
	                    .claim(AUTHORITIES_KEY, user.getRole().getName()) //lay role tu user
	                .signWith(key, SignatureAlgorithm.HS512)
	                .compact();
	    }

	    public Map<String, String> parseToken(String authToken) {
	        Map<String, String> result = new HashMap<>();
	        try {
	            jwtParser.isSigned(authToken);
	            Jws parseClaimsJws = jwtParser.parseClaimsJws(authToken);
	            result.put("Header: ", parseClaimsJws.getHeader().toString());
	            result.put("Body: ", parseClaimsJws.getBody().toString());
	            result.put("Signature: ", parseClaimsJws.getSignature());
	            return result;
	        } catch (ExpiredJwtException e) {
	           System.out.println("Expired JWT token.");
	            throw e;
	        } catch (JwtException | IllegalArgumentException e) {
	           System.out.println("Invalid JWT token.");
	            throw e;
	        }
	    }
	    
		
		 public boolean getAuthentication(String token, String uri) {
		        Claims claims = jwtParser.parseClaimsJws(token).getBody();
		        System.out.println(">>>>>>>>>>>>>>.Claim"+ claims.get(AUTHORITIES_KEY).toString());
		        if (uri.contains("/users")) {
		        if(claims.get(AUTHORITIES_KEY).toString().equalsIgnoreCase("Patient")) //url co /users thi role patient dc phep truy cap
		        	return true;
		        }
		        if (uri.contains("/admin") || uri.contains("/users") ||uri.contains("/doctor")) { //url co /users thi role patient,admin dc phep truy cap
		        if( claims.get(AUTHORITIES_KEY).toString().equalsIgnoreCase("Admin")) 
		        	return true;
		        }
		        if (uri.contains("/doctor")||uri.contains("/doctor")) {
		        if( claims.get(AUTHORITIES_KEY).toString().equalsIgnoreCase("Doctor")) 
		        	return true;
		        }
		        return false;
		 }

}
