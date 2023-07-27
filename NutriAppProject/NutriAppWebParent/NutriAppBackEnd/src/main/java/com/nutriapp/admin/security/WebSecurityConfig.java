package com.nutriapp.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean	
	public UserDetailsService userDetailsService() {
		return new NutriAppUserDetailsService();
	}
	
	@Bean	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// define bean for RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public DaoAuthenticationProvider authenticationProvider() {
		//Authentication based on database looking the user in the database 
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	//Configure authentication provider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/users/**, \"/foods/**").hasAuthority("Admin")
		.antMatchers("/customers/**").hasAnyAuthority("Admin", "Editor")
		.anyRequest().authenticated()
		.and()
			.formLogin()			
			.loginPage("/login")
			.usernameParameter("email")
			.permitAll()
		.and()
			.rememberMe()
				.key("AbcdefghiJklmNoPqRstUvXyz")
				.tokenValiditySeconds(7 * 24 * 60 * 60)// expiration time: 7 days
		.and().logout().permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**",  "/css/**", "/fontawesome/**");
	}
}