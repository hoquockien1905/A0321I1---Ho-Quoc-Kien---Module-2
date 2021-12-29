package com.example.demo.config;

import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("member").password("{noop}123").roles("MEMBER");
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasRole("MEMBER")
                .and().authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/", true)
                .usernameParameter("username")
                .passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/error-403")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
