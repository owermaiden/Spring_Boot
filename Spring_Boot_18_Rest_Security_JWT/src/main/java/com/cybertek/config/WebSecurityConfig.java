package com.cybertek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override  // because we are not using form auth, we need this bean for authentication
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()// we disabled spring cross site forgery özelliğini...
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate")//localhost:8080/authenticate yazan herkes buraya ulaşır...
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
