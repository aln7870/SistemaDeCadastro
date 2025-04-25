package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.EnderecoDto;
import com.inter.SistemaDeCadastro.models.EnderecoModel;
import com.inter.SistemaDeCadastro.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("*")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoModel> salvar(@RequestBody @Valid EnderecoDto dto) {
        return ResponseEntity.ok(enderecoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> listarTodos() {
        return ResponseEntity.ok(enderecoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoModel> atualizar(@PathVariable Integer id, @RequestBody @Valid EnderecoDto dto) {
        return ResponseEntity.ok(enderecoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
