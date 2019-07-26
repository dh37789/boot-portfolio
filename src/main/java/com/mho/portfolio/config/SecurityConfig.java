package com.mho.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

import com.mho.portfolio.config.filter.CustomCorsFilter;
import com.mho.portfolio.config.filter.JwtAuthenticationFilter;
import com.mho.portfolio.user.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private CustomCorsFilter filter;
	private JwtTokenProvider jwtTokenProvider;
	private UserDetailsService userDetailsService;
	private UserService userService;
	
	public SecurityConfig(UserDetailsService userDetailsService, UserService userService) {
		this.userDetailsService = userDetailsService;
		this.userService = userService;
		this.filter = new CustomCorsFilter();
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "*.ico", "/img/**");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.addFilterBefore(filter, SessionManagementFilter.class)
			.httpBasic().disable()
	        .csrf().disable() //rest Api는 csrf보안이 필요없단다 왜필요없을까??
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
	        	.and()
	        .authorizeRequests()
//	        	.antMatchers("/", "/user/**", "/login/**").permitAll()
	        	.antMatchers("/resources/").permitAll()
	        	.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        	.antMatchers("/admin").hasAuthority("ADMIN")
	        	.antMatchers("/usera").hasAuthority("USER")
	        .and()
	        	.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(userService.passwordEncoder());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
