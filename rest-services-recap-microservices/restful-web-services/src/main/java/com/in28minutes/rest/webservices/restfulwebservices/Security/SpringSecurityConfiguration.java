package com.in28minutes.rest.webservices.restfulwebservices.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    // We are going to create our own Security chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // All request should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // If a request is not authorized, show a web page to enter credentials
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF so we can POST, PUT
        http.csrf().disable();

        return http.build();
    }
}
