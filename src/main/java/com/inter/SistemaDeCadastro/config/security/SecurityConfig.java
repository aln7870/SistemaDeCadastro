package com.inter.SistemaDeCadastro.config.security;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.beans.factory.annotation.Value;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    @Value("${jwt.public.key}")
    private RSAPublicKey publicKey;

    @Value("${jwt.private.key}")
    private RSAPrivateKey privateKey;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtDecoder jwtDecoder) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/admin/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/usuario/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/usuario/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/usuario/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuario/**").hasAuthority("SCOPE_ADMIN")
                        // ROTAS DO ALUNO
                        .requestMatchers(HttpMethod.GET, "/aluno/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/aluno/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/aluno/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/aluno/**").hasAuthority("SCOPE_ADMIN")
                        // Rotas para /contato
                        .requestMatchers(HttpMethod.GET, "/contato/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/contato/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/contato/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/contato/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /controleFalta
                        .requestMatchers(HttpMethod.GET, "/controleFalta/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/controleFalta/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/controleFalta/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/controleFalta/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /endereco
                        .requestMatchers(HttpMethod.GET, "/endereco/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/endereco/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/endereco/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/endereco/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /escolaridade
                        .requestMatchers(HttpMethod.GET, "/escolaridade/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/escolaridade/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/escolaridade/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/escolaridade/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /familiar
                        .requestMatchers(HttpMethod.GET, "/familiar/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/familiar/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/familiar/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/familiar/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /inscricaoModalidade
                        .requestMatchers(HttpMethod.GET, "/inscricaoModalidade/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/inscricaoModalidade/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/inscricaoModalidade/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/inscricaoModalidade/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /modalidade
                        .requestMatchers(HttpMethod.GET, "/modalidade/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/modalidade/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/modalidade/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/modalidade/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /ocupacao
                        .requestMatchers(HttpMethod.GET, "/ocupacao/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/ocupacao/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/ocupacao/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/ocupacao/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /saude
                        .requestMatchers(HttpMethod.GET, "/saude/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/saude/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/saude/**").hasAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/saude/**").hasAuthority("SCOPE_ADMIN")

                        // Rotas para /turno
                        .requestMatchers(HttpMethod.GET, "/turno/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/turno/**").hasAnyAuthority("SCOPE_USER", "SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/turno/**").hasAuthority("SCOPE_ADMIN")
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(Customizer.withDefaults())
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        var jwk = new RSAKey.Builder(this.publicKey).privateKey(this.privateKey).build();
        var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }
}
