package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoCadastroDto;
import com.inter.SistemaDeCadastro.services.AlunoCadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunoCadastro")
@CrossOrigin("*")
public class AlunoCadastroController {

        @Autowired
        private AlunoCadastroService alunoCadastroService;

        @PostMapping()
        public ResponseEntity<Void> cadastrarAluno(@RequestBody @Valid AlunoCadastroDto dto) {
            alunoCadastroService.cadastrarAlunoCompleto(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

