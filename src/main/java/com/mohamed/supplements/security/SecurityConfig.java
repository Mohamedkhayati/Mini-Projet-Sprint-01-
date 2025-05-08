package com.mohamed.supplements.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	@Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
        		.requestMatchers(HttpMethod.GET, "/supplements/api/**").permitAll()
        	    .requestMatchers(HttpMethod.POST, "/supplements/api/**").permitAll()

                // USER, AGENT, ADMIN → peuvent consulter
                .requestMatchers("/ListeSupplements").hasAnyAuthority("ADMIN", "AGENT", "USER")

                // AGENT et ADMIN peuvent afficher formulaire de création
                .requestMatchers("/showCreate").hasAnyAuthority("ADMIN", "AGENT")

                // AGENT et ADMIN peuvent ajouter
                .requestMatchers("/saveSupplements").hasAnyAuthority("ADMIN", "AGENT")

                // ADMIN seul peut modifier, supprimer, mettre à jour
                .requestMatchers("/modifierSupplement", "/supprimerSupplement", "/updateSupplement").hasAuthority("ADMIN")
                .requestMatchers("/login","/webjars/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/suupplements/api/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/suupplements/api/**").permitAll()
                .anyRequest().authenticated())
        
        //.formLogin(Customizer.withDefaults())
        .formLogin((formLogin) -> formLogin
        		 .loginPage("/login")
        		 .defaultSuccessUrl("/"))
        
        .httpBasic(Customizer.withDefaults())
        .exceptionHandling(exception -> exception.accessDeniedPage("/accessDenied"))
        .csrf(csrf -> csrf.disable());

        
        return http.build();
    }

   /* @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select username, password, enabled from user where username = ?");
            
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT u.username, r.role as authority " +
            "FROM user_role ur, user u, role r " +
            "WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?");

        return jdbcUserDetailsManager;
    }*/
    
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder passwordEncoder = passwordEncoder();

        UserDetails admin = User
            .withUsername("admin")
            .password(passwordEncoder.encode("123"))
            .authorities("ADMIN")
            .build();
        UserDetails userMohamed = User
            .withUsername("mohamed")
            .password(passwordEncoder.encode("123"))
            .authorities("AGENT","USER")
            .build();
        UserDetails user1 = User
            .withUsername("user1")
            .password(passwordEncoder.encode("123"))
            .authorities("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, userMohamed, user1);
    }*/
}