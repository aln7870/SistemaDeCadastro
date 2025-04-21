package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoDto;
import com.inter.SistemaDeCadastro.controllers.dtos.AlunoResponseDto;
import com.inter.SistemaDeCadastro.controllers.dtos.views.AlunoPorModalidadeDto;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    private String getLoggedInUsername() { // Renomeado para clareza
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDto> criarAluno(@RequestBody @Valid AlunoDto alunoDto) {
        String createdBy = getLoggedInUsername();
        var codUser = Integer.parseInt(createdBy);
        AlunoResponseDto novoAluno = alunoService.criarAluno(alunoDto, codUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    //teste view
    @GetMapping("/view")
    public ResponseEntity<List<AlunoPorModalidadeDto>> listarAlunosPorModalidade() {
        List<AlunoPorModalidadeDto> alunos = alunoService.listarAlunosPorModalidade();
        return ResponseEntity.ok(alunos);
    }
/* teste com a procedure
    // Endpoint para filtrar alunos por nome e modalidade
    @GetMapping("/filtrar")
    public ResponseEntity<List<AlunoPorModalidadeDto>> filtrarAlunosPorModalidade(
            @RequestParam(required = false) String nomeAluno,
            @RequestParam(required = false) Integer codModalidade) {
        List<AlunoPorModalidadeDto> alunosFiltrados = alunoService.filtrarAlunosPorModalidade(nomeAluno, codModalidade);
        return ResponseEntity.ok(alunosFiltrados);
    }
*/
    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> listarAlunos() {
        List<AlunoResponseDto> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAlunoPorId(@PathVariable Integer id) {
        Optional<AlunoModel> aluno = alunoService.buscarAlunoPorId(id);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        return ResponseEntity.ok(aluno.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAluno(@PathVariable Integer id, @RequestBody @Valid AlunoDto alunoDto) {
        // Passar o nome do usuário para o serviço para atualizar o aluno
        AlunoResponseDto alunoAtualizado = alunoService.atualizarAluno(id, alunoDto);
        return ResponseEntity.ok(alunoAtualizado);
    }
}
