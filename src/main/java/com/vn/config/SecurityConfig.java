package com.vn.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService customUserDetailService;
	
	
	//config for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService)
			.passwordEncoder(passwordEncoder());
	}
	
	// config for authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		
		http.authorizeRequests().antMatchers("/", "/login", "/logout","/admin").permitAll();
		
//		http.authorizeRequests().antMatchers("/admin", "/admin/*").hasRole("ADMIN");
	
		http.authorizeRequests().antMatchers("/user-info").hasAnyRole("ADMIN", "MEMBER");
	
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		http.authorizeRequests().and().formLogin().loginProcessingUrl("/login_post")
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.defaultSuccessUrl("/home")
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login");
		
		http.authorizeRequests().and()
			.rememberMe()
			.tokenRepository(tokenRepository())
			.tokenValiditySeconds(1 * 24 * 60 * 60);
		
	}
	
	@Bean
	PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}
	
}
