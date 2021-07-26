package com.supermarket.supermarket.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String[] PRE_AUTHENTICAITON_ALLOWED_ENDPOINT_PATTERNS = {
            "/contact",
            "/feedback",
            "/images/**",

    };

    @Override
    //override storage //DB //inmemory
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .authorities("Admin_Role");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

}
