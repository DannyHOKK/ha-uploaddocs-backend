package HA.DocUploadApplication.core.security.filter;

import HA.DocUploadApplication.User.Service.impl.UserDetailServiceImpl;
import HA.DocUploadApplication.core.utils.JwtUtils;
import HA.DocUploadApplication.core.utils.SpringContextUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    public static final String USERNAME = "username";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(JwtUtils.TOKEN_HEADER);

        if (header == null || !header.startsWith(JwtUtils.TOKEN_PREFIX)){
            filterChain.doFilter(request,response);
            return;
        }
        String token = header.replace(JwtUtils.TOKEN_PREFIX, "");
        if (token != null && !JwtUtils.TOKEN_UNDEFINED.equals(token)){
            Claims claims = Jwts.parser().setSigningKey(JwtUtils.SECRET_KEY).parseClaimsJws(token).getBody();
            String username = claims.get(USERNAME).toString();
            if (username != null) {
                UserDetailServiceImpl userDetailService = SpringContextUtil.getBean(UserDetailServiceImpl.class);
                UserDetails userDetails = userDetailService.loadUserByUsername(username);
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            }


        filterChain.doFilter(request,response);
    }
}
