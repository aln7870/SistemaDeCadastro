package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.ModalidadeDto;
import com.inter.SistemaDeCadastro.models.ModalidadeModel;
import com.inter.SistemaDeCadastro.services.ModalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalidade")
public class ModalidadeController {

    @Autowired
    private ModalidadeService modalidadeService;

    @PostMapping
    public ResponseEntity<ModalidadeModel> criar(@RequestBody ModalidadeDto dto) {
        return ResponseEntity.ok(modalidadeService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ModalidadeModel>> listarTodas() {
        return ResponseEntity.ok(modalidadeService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalidadeModel> buscarPorId(@PathVariable Integer id) {
        return modalidadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModalidadeModel> atualizar(@PathVariable Integer id, @RequestBody ModalidadeDto dto) {
        return ResponseEntity.ok(modalidadeService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        modalidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
