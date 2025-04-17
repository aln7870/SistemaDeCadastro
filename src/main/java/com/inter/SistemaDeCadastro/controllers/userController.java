package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.Userdto;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid Userdto userdto){
        var user = new UserModel();
        BeanUtils.copyProperties(userdto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }
}
