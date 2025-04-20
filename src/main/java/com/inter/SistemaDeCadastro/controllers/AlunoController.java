package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoDto;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Método para obter o nome do usuário logado (usando Spring Security)
    private String getLoggedInUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName(); // Retorna o nome do usuário logado
    }

    @PostMapping
    public ResponseEntity<AlunoModel> criarAluno(@RequestBody @Valid AlunoDto alunoDto) {
        // Obter o nome do usuário logado
        String createdBy = getLoggedInUser();

        // Passar o nome do usuário para o serviço
        AlunoModel novoAluno = alunoService.criarAluno(alunoDto, createdBy);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<Object> listarAlunos() {
        List<AlunoModel> alunos = alunoService.listarAlunos();
        if (alunos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum aluno encontrado.");
        }
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAlunoPorId(@PathVariable Long id) {
        Optional<AlunoModel> aluno = alunoService.buscarAlunoPorId(id);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        return ResponseEntity.ok(aluno.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoDto alunoDto) {
        // Obter o nome do usuário logado
        String createdBy = getLoggedInUser();

        // Passar o nome do usuário para o serviço para atualizar o aluno
        AlunoModel alunoAtualizado = alunoService.atualizarAluno(id, alunoDto, createdBy);
        return ResponseEntity.ok(alunoAtualizado);
    }
}
