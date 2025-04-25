package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.EscolaridadeDto;
import com.inter.SistemaDeCadastro.services.EscolaridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escolaridade")
@CrossOrigin("*")
public class EscolaridadeController {

    @Autowired
    private EscolaridadeService escolaridadeService;

    // Endpoint para criar uma nova escolaridade
    @PostMapping
    public ResponseEntity<EscolaridadeDto> criar(@RequestBody EscolaridadeDto escolaridadeDto) {
        EscolaridadeDto novaEscolaridade = escolaridadeService.criar(escolaridadeDto);
        return new ResponseEntity<>(novaEscolaridade, HttpStatus.CREATED);
    }

    // Endpoint para listar todas as escolaridades
    @GetMapping
    public ResponseEntity<List<EscolaridadeDto>> listarTodas() {
        List<EscolaridadeDto> escolaridades = escolaridadeService.listarTodas();
        return new ResponseEntity<>(escolaridades, HttpStatus.OK);
    }

    // Endpoint para buscar escolaridade por ID
    @GetMapping("/{id}")
    public ResponseEntity<EscolaridadeDto> buscarPorId(@PathVariable Integer id) {
        Optional<EscolaridadeDto> escolaridadeDto = escolaridadeService.buscarPorId(id);
        return escolaridadeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar uma escolaridade
    @PutMapping("/{id}")
    public ResponseEntity<EscolaridadeDto> atualizar(@PathVariable Integer id, @RequestBody EscolaridadeDto escolaridadeDto) {
        try {
            EscolaridadeDto escolaridadeAtualizada = escolaridadeService.atualizar(id, escolaridadeDto);
            return new ResponseEntity<>(escolaridadeAtualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar uma escolaridade
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            escolaridadeService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
