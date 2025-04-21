package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.Userdto;
import com.inter.SistemaDeCadastro.models.UserModel;
import com.inter.SistemaDeCadastro.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/cadastro")
    public ResponseEntity<UserModel> criarUser(@RequestBody @Valid Userdto userdto) {
        UserModel novoUser = userService.criarUser(userdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<UserModel> users = userService.listarUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário registrado.");
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> getUserById(@PathVariable("idUsuario") Integer idUsuario) {
        Optional<UserModel> user = userService.buscarUserPorId(idUsuario);

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Object> updateUser(@PathVariable("idUsuario") Integer idUsuario, @RequestBody @Valid Userdto userdto) {
        var userAtualizado = userService.atualizarUser(idUsuario, userdto);
        return ResponseEntity.ok(userAtualizado);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> deletarUser(@PathVariable("idUsuario") Integer idUsuario){
    UserModel userDeletado = userService.deleteUser(idUsuario);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado.");
    }

}
