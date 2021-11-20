package com.example.springbootpractice.configuration;

import com.example.springbootpractice.services.implementations.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.springbootpractice.utils.Constants.Security.*;

/**
 * Configuration for Security
 *
 * @author Tairi
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String role = "ROLE_";
        String admin = AUTHORITY_ADMIN.replace(role, "");
        String teacher = AUTHORITY_TEACHER.replace(role, "");
        String student = AUTHORITY_STUDENT.replace(role, "");

        httpSecurity.authorizeRequests()
                    .antMatchers("/", "signup")
                    .permitAll()
                    .antMatchers("/user/**")
                    .hasRole(admin)
                    .antMatchers("/teacher/**")
                    .hasAnyRole(admin, teacher)
                    .antMatchers("/student")
                    .hasAnyRole(admin, teacher)
                    .and()
                    .httpBasic()
                    .and()
                    .formLogin()
                    .and()
                    .logout().permitAll(false).logoutSuccessUrl("/")
                    .and()
                    .csrf().disable();
    }
}
