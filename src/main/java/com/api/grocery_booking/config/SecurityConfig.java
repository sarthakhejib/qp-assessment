package com.api.grocery_booking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${admin.pattern}")
    private String adminPattern;

    @Value("${user.pattern}")
    private String userPattern;

    @Value("${admin.username}")
    private String adminName;

    @Value("${user.username}")
    private String userName;

    @Value("${admin.password}")
    private String adminPassword;

    @Value("${user.password}")
    private String userPassword;

    private static final String ADMIN_ROLE= "ADMIN";
    private static final String USER_ROLE= "USER";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http    .csrf(customizer-> customizer.disable())
                .authorizeRequests()
                .requestMatchers(adminPattern).hasRole(ADMIN_ROLE)
                .requestMatchers(userPattern).hasRole(USER_ROLE)
                .anyRequest().authenticated()
                .and()
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(adminName)
                .password(adminPassword)
                .roles(ADMIN_ROLE)
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username(userName)
                .password(userPassword)
                .roles(USER_ROLE)
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
