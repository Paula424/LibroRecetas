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
                // Desactivar CSRF solo para H2
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )
                // Permitir iframe de la misma origen (para H2 console)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                // Configurar qué URLs se permiten sin autenticación
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // H2 permitido
                        .anyRequest().permitAll() //todo lo demás también permitido (solo para dev)
                )
                // Deshabilitar login form
                .formLogin(form -> form.disable());

        return http.build();
    }
}

