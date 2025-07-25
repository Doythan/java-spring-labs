package org.example.securityapp.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // H2 Consle은 ifrmae으로 동작하도록, 이 설정이 필요.
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

        http.csrf(configure -> configure.disable());

        http.formLogin(form -> form
                .loginPage("/login-form")
                .usernameParameter("username")
                .loginProcessingUrl("/login")  // username=ssar&password=1234
                .defaultSuccessUrl("/main")
        );

        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/main").authenticated()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
        );

        return http.build();
    }
}