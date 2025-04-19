package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.ControleFaltaDto;
import com.inter.SistemaDeCadastro.models.ControleFaltaModel;
import com.inter.SistemaDeCadastro.services.ControleFaltaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controle-faltas")
public class ControleFaltaController {

    @Autowired
    private ControleFaltaService controleFaltaService;

    @GetMapping
    public List<ControleFaltaModel> listarTodos() {
        return controleFaltaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ControleFaltaModel buscarPorId(@PathVariable Long id) {
        return controleFaltaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Controle de falta não encontrado"));
    }

    @PostMapping
    public ControleFaltaModel criar(@RequestBody @Valid ControleFaltaDto dto) {
        return controleFaltaService.criar(dto);
    }

    @PutMapping("/{id}")
    public ControleFaltaModel atualizar(@PathVariable Long id, @RequestBody @Valid ControleFaltaDto dto) {
        return controleFaltaService.atualizar(id, dto);
    }
}
