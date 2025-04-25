package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.FamiliarDto;
import com.inter.SistemaDeCadastro.models.FamiliarModel;
import com.inter.SistemaDeCadastro.services.FamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familiar")
@CrossOrigin("*")
public class FamiliarController {

    @Autowired
    private FamiliarService familiarService;

    @PostMapping
    public ResponseEntity<FamiliarModel> criar(@RequestBody FamiliarDto dto) {
        return ResponseEntity.ok(familiarService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<FamiliarModel>> listarTodos() {
        return ResponseEntity.ok(familiarService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliarModel> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(familiarService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliarModel> atualizar(@PathVariable Integer id, @RequestBody FamiliarDto dto) {
        return ResponseEntity.ok(familiarService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        familiarService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
