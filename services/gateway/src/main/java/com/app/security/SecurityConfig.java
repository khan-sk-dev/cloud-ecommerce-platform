package com.app.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.csrf(ServerHttpSecurity.CsrfSpec::disable) // Disable CSRF
                .authorizeExchange(exchange -> exchange.pathMatchers("/eureka/**").permitAll() // Allow access to Eureka
                        .anyExchange().authenticated()          // All other requests must be authenticated
                ).oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())) // Use JWT validation
                .build();
    }

}