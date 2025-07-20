package com.nt.config;

import com.nt.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;  // ✅ lowercase

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	System.out.println("SecurityConfig.securityFilterChain()");  
    	
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**", "/api/test/public").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        System.out.println("SecurityConfig.securityFilterChain() End ");
        return http.build();
      
    }
}
