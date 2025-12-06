package dev.java10x.CadastroDeNinjas.config;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().permitAll() // Libera tudo no localhost
                )
                .csrf(csrf -> csrf.disable()) // desabilita CSRF completamente
                .cors(cors -> cors.disable()) // evita bloqueios no localhost
                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable()) // necessário para H2 Console
                )
                .formLogin(form -> form.disable()) // remove autenticação padrão
                .httpBasic(basic -> basic.disable()); // remove popup básico de login

        return http.build();
    }
}
