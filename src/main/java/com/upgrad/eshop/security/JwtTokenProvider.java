package com.upgrad.eshop.security;

import com.upgrad.eshop.exceptions.UserDetailsNotfoundException;
import com.upgrad.eshop.services.UserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;


@Component
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";

    @Value("${security.jwt.token.expire-length:600000}")
    private long validityInMilliseconds = 3600000;

    @Autowired
    UserService userService;

    @PostConstruct
    protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("X-Access-Token");
        if (bearerToken != null) {
            return bearerToken.trim();
        }
        return null;
    }

    public boolean validateToken(String token) {
     try {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
                if (claims.getBody().getExpiration().before(new Date())) {
                    return false;
                }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
        }
    }
    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) throws UserDetailsNotfoundException {
        UserDetails userDetails = this.userService.loadCustomerDetails(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

}
