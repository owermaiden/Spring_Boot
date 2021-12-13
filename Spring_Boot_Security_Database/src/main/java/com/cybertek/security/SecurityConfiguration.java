package com.cybertek.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()// request should be authorized
                .antMatchers("index.html").permitAll()
                .antMatchers("/profile/**").authenticated() // all the roles are authenticated
                .antMatchers("/admin/**").hasRole("ADMIN")  // only admin role is permitted or .hasAuthority("ROLE_ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
                .and()
                .httpBasic(); // basic http authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("ower").password(passwordEncoder().encode("ower123")).roles("USER")
                .and()
                .withUser("manager").password(passwordEncoder().encode("manager123")).roles("MANAGER");

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

