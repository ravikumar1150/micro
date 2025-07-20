package com.nt.filter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nt.config.SecurityConfig;
import com.nt.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	//@Autowired
   // private  SecurityConfig securityConfig;

	@Autowired
	private  JwtService jwtService;

	
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
		System.out.println("JwtAuthFilter.doFilterInternal()");
	    String path = request.getServletPath();

	    // ✅ Skip JWT check for login/public endpoints
	    if (path.startsWith("/api/auth") || path.startsWith("/api/test/public")) {
	        filterChain.doFilter(request, response);
	        return;
	    }

	    String authHeader = request.getHeader("Authorization");

	    if (authHeader != null && authHeader.startsWith("Bearer ")) {
	        String token = authHeader.substring(7);

	        if (jwtService.validateToken(token)) {
	            String userName = jwtService.extractUserName(token);

	            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
	                    userName, null, Collections.emptyList());

	            SecurityContextHolder.getContext().setAuthentication(auth);
	        }
	    }

	    
	    filterChain.doFilter(request, response);
	    
	    System.out.println("JwtAuthFilter.doFilterInternal() End ");
	   
	}

}
