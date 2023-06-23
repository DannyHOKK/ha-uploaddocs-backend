package HA.DocUploadApplication.core.config;

import HA.DocUploadApplication.User.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider (){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }


    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .and().cors().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/admin/signUp").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.authenticationProvider(daoAuthenticationProvider());

        return httpSecurity.build();
    }

    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("12345678"))
                .authorities("ROLE_USER")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

}
