package JhonBook.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita o CSRF (recomendado apenas para desenvolvimento)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Permite acesso ao console do H2
                        .anyRequest().authenticated() // Exige autenticação para outras requisições
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()) // Substitui o método obsoleto
                );

        return http.build();
    }
}