package com.nt.service;


import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    

    private static final String SECRET_KEY = "6B697663696F647261676F6E69736E6F6E6C796F756B6E6F77696E676C6F6E67";

 
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

 
    public String generateToken(String username) {
    	System.out.println("JwtService.generateToken()");
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("DemoApp")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
      
    }

   public String extractUserName(String token) {
	   System.out.println("JwtService.extractUserName()");
	   return Jwts.parserBuilder()
			      .setSigningKey(getSignKey())
			      .build()
			      .parseClaimsJws(token)
			      .getBody()
			      .getSubject();
   }

   public  boolean validateToken(String token) {
	   
	   System.out.println("JwtService.validateToken()");
	   
	   try {
		   
		   Jwts.parserBuilder()
		       .setSigningKey(getSignKey())
		       .build()
		       .parseClaimsJws(token);
		  
		   return true;
		       
		       
	   }catch(JwtException ex) {
		  
		  System.out.println("Token is Invalid By ( public  boolean valitaToken(String token)) meyhod  "); 
		   return false;
		   
	   }
	   
   }
    
}
