package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * This is Spring Security Config
 * 
 * @author Mohit Sharma
 *
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin")
				.password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("employee")
				.password("{noop}123456").roles("EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin")
				.access("hasRole('ADMIN')").antMatchers("/employee")
				.access("hasRole('EMPLOYEE')").and()
				.formLogin()
				. // login configuration
				loginPage("/login").loginProcessingUrl("/Login")
				.defaultSuccessUrl("/default").failureUrl("/error").and()
				.logout().logoutUrl("/Logout")// logout configuration
				.logoutSuccessUrl("/login");
	}
}
