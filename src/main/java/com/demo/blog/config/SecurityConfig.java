//package com.demo.blog.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.demo.blog.security.CustomUserDetailsService;
//import com.demo.blog.security.JwtAuthenticationEntryPoint;
//import com.demo.blog.security.JwtAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableWebMvc
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//	
//
//	    @Autowired
//	    private CustomUserDetailsService customUserDetailsService;
//	    
//	    @Autowired
//	    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	    
//	    @Autowired
//	    private JwtAuthenticationFilter jwtAuthenticationFilter;
//	    
//	    @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    	http.
//	    	csrf(csrf -> csrf.disable())
//	    	.cors(cors -> cors.disable())
//	    	.authorizeHttpRequests(auth ->
//	    		auth.requestMatchers("/api/v1/auth/**").permitAll()
//	    		
//                .requestMatchers("/auth/login")
//                .permitAll()
//                .requestMatchers("/v3/api-docs")
//                .permitAll()
//                .anyRequest()
//                .authenticated())
//                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//	    	
//	   
//	    	http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//	    	
//	    	http.authenticationProvider(daoAuthenticationProvider());
//	    	
//	    	DefaultSecurityFilterChain defaultSecurityFilterChain =  http.build();
//	    	return defaultSecurityFilterChain;
//	    }
//	    
////	    @Bean
////	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
////	        // configuration
////	    	http.csrf().disable()
////	    	.authorizeHttpRequests()
////	    	.anyRequest()
////	    	.authenticated()
////	    	.and()
////	    	.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
////	    	.and()
////	    	.sessionManagement()
////	    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////	    	
////	    	http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
////	    	
//////	        http.csrf(csrf ->csrf.disable())
//////	                .cors(cors -> cors.disable())
//////	                .authorizeHttpRequests(auth ->
//////	                        auth.requestMatchers("/home/**")
//////	                                .authenticated()
//////	                                .requestMatchers("/auth/login").permitAll()
//////	                                .anyRequest().authenticated())
//////	                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//////	                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//////	        ;
//////	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
////
////
////	        return http.build();
////	    }
////	    
//	    
//	    
//	    
////	    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////	    	auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());
////	    }
//	    
//	    
//	    
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	    	return new BCryptPasswordEncoder();
//	    }
//	    
//	    
//	    @Bean
//	    public DaoAuthenticationProvider daoAuthenticationProvider() {
//	    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	    	provider.setUserDetailsService(this.customUserDetailsService);
//	    	provider.setPasswordEncoder(passwordEncoder());
//	    	return provider;
//	    }
//	    
//	    @Bean
//	    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception{
//	    	return configuration.getAuthenticationManager();
//	    }
//}
