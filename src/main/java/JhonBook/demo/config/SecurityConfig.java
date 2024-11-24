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
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Libera H2 Console
                        .requestMatchers("/users/**").permitAll()      // Permite acesso ao endpoint de usuários
                        .requestMatchers("/authors/**").permitAll()    // Permite acesso ao endpoint de autores
                        .requestMatchers("/books/**").permitAll()
                        .anyRequest().authenticated()                 // Exige autenticação para o restante
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Necessário para H2 Console
                );

        return http.build();
    }
}
