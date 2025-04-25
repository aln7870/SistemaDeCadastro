package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.ContatoDto;
import com.inter.SistemaDeCadastro.models.ContatoModel;
import com.inter.SistemaDeCadastro.services.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@CrossOrigin("*")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @PostMapping
    public ResponseEntity<ContatoModel> criarContato(@RequestBody @Valid ContatoDto dto) {
        ContatoModel novo = contatoService.salvarContato(dto);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<Object> listarContatos() {
        List<ContatoModel> lista = contatoService.listarContatos();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("Nenhum contato encontrado.");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Integer id) {
        return contatoService.buscarPorId(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Contato não encontrado."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarContato(@PathVariable Integer id, @RequestBody @Valid ContatoDto dto) {
        ContatoModel atualizado = contatoService.atualizarContato(id, dto);
        return ResponseEntity.ok(atualizado);
    }
}
