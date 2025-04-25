package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.SaudeDto;
import com.inter.SistemaDeCadastro.models.SaudeModel;
import com.inter.SistemaDeCadastro.services.SaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saude")
@CrossOrigin("*")
public class SaudeController {

    @Autowired
    private SaudeService service;

    @PostMapping
    public ResponseEntity<SaudeModel> create(@RequestBody SaudeDto dto) {
        SaudeModel saudeModel = service.save(dto);
        return ResponseEntity.ok(saudeModel);  // Retorna 200 OK com o modelo criado
    }

    @GetMapping
    public ResponseEntity<List<SaudeModel>> getAll() {
        List<SaudeModel> saudeModels = service.findAll();
        return ResponseEntity.ok(saudeModels);  // Retorna 200 OK com a lista de modelos
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaudeModel> getById(@PathVariable Integer id) {
        SaudeModel saudeModel = service.findById(id);
        if (saudeModel != null) {
            return ResponseEntity.ok(saudeModel);  // Retorna 200 OK com o modelo encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaudeModel> update(@PathVariable Integer id, @RequestBody SaudeDto dto) {
        SaudeModel updatedSaudeModel = service.update(id, dto);
        if (updatedSaudeModel != null) {
            return ResponseEntity.ok(updatedSaudeModel);  // Retorna 200 OK com o modelo atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        SaudeModel saudeModel = service.findById(id);
        if (saudeModel != null) {
            service.delete(id);
            return ResponseEntity.noContent().build();  // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se não encontrar o modelo
        }
    }
}
