package br.com.LC.Spring_enterprise.Infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public UserDetailsService registerUsuaryData(){
        UserDetails usuaryOne = User.builder()
                .username("lucascrippa@teste.com.br")
                .password("{noop}Mortadela").build();
        return  new InMemoryUserDetailsManager(usuaryOne);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desabilita CSRF para testes via Postman
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // todos os endpoints precisam de autenticação
                )
                .httpBasic(); // habilita Basic Auth
        return http.build();
    }


}
