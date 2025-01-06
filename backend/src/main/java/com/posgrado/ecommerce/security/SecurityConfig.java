package com.posgrado.ecommerce.security;

import com.posgrado.ecommerce.security.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

  private JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeHttpRequests()
        .requestMatchers("/auth/**").permitAll()
        .requestMatchers("/categories/**").permitAll()
        .requestMatchers("/orders/**").permitAll()
        .requestMatchers("/products/**").permitAll()
        .requestMatchers("/roles/**").permitAll()
        .requestMatchers("/test/**").permitAll()
        .requestMatchers("/users/**").permitAll()
        .anyRequest().authenticated();
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
