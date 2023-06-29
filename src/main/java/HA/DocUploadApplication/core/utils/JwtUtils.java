package HA.DocUploadApplication.core.utils;

import HA.DocUploadApplication.User.Service.UserDetail;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtils{

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String TOKEN_UNDEFINED = "undefined";

    public static final String SECRET_KEY = "hospital_authority";

    @Autowired
    private static UserRepository userRepository;

    public static String buildJwt(Authentication authentication){
        UserDetail user = (UserDetail) authentication.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("email", user.getEmail());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TimeUnit.DAYS.toSeconds(20)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    };



}
