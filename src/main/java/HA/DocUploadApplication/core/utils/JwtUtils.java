package HA.DocUploadApplication.core.utils;

import HA.DocUploadApplication.User.Service.UserDetail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtils{

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String TOKEN_UNDEFINED = "undefined";

    public static final String SECRET_KEY = "hospital_authority";

    public static String buildJwt(Authentication authentication){
        UserDetail user = (UserDetail) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TimeUnit.DAYS.toSeconds(20)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    };


}
