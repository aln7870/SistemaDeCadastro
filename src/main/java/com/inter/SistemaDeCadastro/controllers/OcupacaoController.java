package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.OcupacaoDto;
import com.inter.SistemaDeCadastro.models.OcupacaoModel;
import com.inter.SistemaDeCadastro.services.OcupacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocupacao")
public class OcupacaoController {

    @Autowired
    private OcupacaoService ocupacaoService;

    @PostMapping
    public ResponseEntity<OcupacaoModel> criar(@RequestBody OcupacaoDto dto) {
        return ResponseEntity.ok(ocupacaoService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<OcupacaoModel>> listarTodas() {
        return ResponseEntity.ok(ocupacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcupacaoModel> buscarPorId(@PathVariable Integer id) {
        return ocupacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcupacaoModel> atualizar(@PathVariable Integer id, @RequestBody OcupacaoDto dto) {
        return ResponseEntity.ok(ocupacaoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        ocupacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
