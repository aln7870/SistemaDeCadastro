package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.ControleFaltaDto;
import com.inter.SistemaDeCadastro.controllers.dtos.MarcarFaltaDto;
import com.inter.SistemaDeCadastro.models.ControleFaltaModel;
import com.inter.SistemaDeCadastro.services.ControleFaltaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controleFalta")
@CrossOrigin("*")
public class ControleFaltaController {

    @Autowired
    private ControleFaltaService controleFaltaService;

    @GetMapping
    public List<ControleFaltaModel> listarTodos() {
        return controleFaltaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ControleFaltaModel buscarPorId(@PathVariable Integer id) {
        return controleFaltaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Controle de falta não encontrado"));
    }

    @PostMapping
    public ControleFaltaModel criar(@RequestBody @Valid ControleFaltaDto dto) {
        return controleFaltaService.criar(dto);
    }

    @PutMapping("/{id}")
    public ControleFaltaModel atualizar(@PathVariable Integer id, @RequestBody @Valid ControleFaltaDto dto) {
        return controleFaltaService.atualizar(id, dto);
    }
    @PostMapping("/Marcar")
    public ResponseEntity<String> marcarFaltas(@RequestBody List<MarcarFaltaDto> faltas) {
        try {
            for (MarcarFaltaDto dto : faltas) {
                controleFaltaService.marcarFalta(dto);
            }
            return ResponseEntity.ok("Faltas marcadas com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro interno ao marcar faltas.");
        }
    }
}
