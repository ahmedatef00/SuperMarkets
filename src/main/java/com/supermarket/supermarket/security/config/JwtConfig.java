package com.supermarket.supermarket.security.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@Getter

//SecurityConstants
public class JwtConfig {
    @Value("${security.jwt.uri:}")
    private String Uri;

    @Value("${security.jwt.prefix:}")
    private String prefix;


    //    in milliseconds
    @Value("${security.jwt.expiration:1234}")
    private int expiration;

    @Value("${security.jwt.secret:}")
    private String secret;


}
