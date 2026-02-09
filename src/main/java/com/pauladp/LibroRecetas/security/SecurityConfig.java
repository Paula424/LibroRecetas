package com.pauladp.LibroRecetas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())) // Permite iframe
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // H2 permitido
                        .anyRequest().authenticated() // lo demás requiere login
                )
                .formLogin(form -> form.disable()); // desactiva login

        return http.build();
    }
}

