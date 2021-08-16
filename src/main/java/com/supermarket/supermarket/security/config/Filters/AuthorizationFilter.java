package com.supermarket.supermarket.security.config.Filters;

import com.supermarket.supermarket.security.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    @Autowired
    private JwtConfig jwtConfig;

    public AuthorizationFilter(AuthenticationManager authenticationManager, JwtConfig jwtconfig) {
        super(authenticationManager);
        this.jwtConfig = jwtconfig;
    }

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        // 1. get the authentication header. Tokens are supposed to be passed in the authentication header


        String header = req.getHeader("Authorization");
        // 2. validate the header and check the prefix

        if (header == null|| !header.startsWith(jwtConfig.getPrefix())) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = authenticate(req);

    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if (token != null) {
            Claims user = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes())).build()
                    .parseClaimsJws(token)
                    .getBody();


            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            } else {
                return null;
            }

        }
        return null;
    }

}
