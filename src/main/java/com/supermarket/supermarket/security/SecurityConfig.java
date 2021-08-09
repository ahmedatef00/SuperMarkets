package com.supermarket.supermarket.security;

import com.supermarket.supermarket.repository.UserRepository;
import com.supermarket.supermarket.service.impl.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.lang.String.format;


@Configuration
@EnableWebSecurity
@Data
@Order(1000)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private final UserService userService;


    @Override
    //override storage //DB //inmemory
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**
         * the auth.userDetailsService function will initiate DaoAuthntication provier instance usinjg my
         * implemntation of the user detqauls servic4e
         * register  it in the authntication  mnanagerr
         *
         */
        auth.userDetailsService(username -> userService.findByUsername(username).orElseThrow(() ->

                new UsernameNotFoundException(format("USER: %s, NOT FOUND", username)
                )
        ));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

}
