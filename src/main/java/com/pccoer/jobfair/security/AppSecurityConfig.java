/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pccoer.jobfair.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 *
 * @author rasika
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      auth.inMemoryAuthentication().withUser("sanjay").password("{noop}1234").roles("USER");
//  }
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    AuthenticationProvider provider(){
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(userDetailsService);
        p.setPasswordEncoder(new BCryptPasswordEncoder());

        return p;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.csrf().disable()
    		.authorizeRequests()
    			.antMatchers("/login", "/hello").permitAll()
    			.anyRequest().authenticated()
    			.and()
    		.formLogin()
    			.loginPage("/login").permitAll()
    			.and()
    		.logout()
    			.invalidateHttpSession(true)
    			.clearAuthentication(true)
    			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    			.logoutSuccessUrl("/logout-success").permitAll();
    	System.out.println("In configuration");
    }
    
//  @Bean
//  @Override
//  public UserDetailsService userDetailsServiceBean() {
//      UserDetails user = User.withDefaultPasswordEncoder()
//              .username("abcd")
//              .password("1234")
//              .roles("USER")
//              .build();
//      return new InMemoryUserDetailsManager(user);
//  } 
}
