package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.LoginRequest;
import com.inter.SistemaDeCadastro.controllers.dtos.LoginResponse;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.models.RoleModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class TokenLoginController {
    @Autowired
    JwtEncoder jwtEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){

        Optional<UserModel> user = userRepository.findByEmail(loginRequest.email());

        //    String nome = user.get().getNome();


        // horario atual
        var now = Instant.now();
        //5 minutos
        var expiresIn = 300L;

        var scope = user.get().getRoles()
                .stream()
                .map(RoleModel::getNome)
                .collect(Collectors.joining());

        var claims = JwtClaimsSet.builder()
                .issuer("gerado pelo back end")
                .subject(user.get().getIdUsuario().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("escopo", scope)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        if (user.isEmpty()){
            throw new BadCredentialsException("usuario vazio");
        }
        System.out.println("chegou ate senha");
   /*     if (user.get().getLogin().equals("ADMIN") && user.get().getSenha().equals("123")){
            return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
        }*/
        //NUNCA ESQUEÇA DA DEPENDENCIA VALIDATIONS E DE VALIDAR OS DTOS PQP AAAAAAAAAAAAA
        if (!passwordEncoder.matches(loginRequest.senha(), user.get().getSenha())){
            //(!user.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("senha incorreta");
        }
        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }

}
