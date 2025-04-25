package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.InscricaoModalidadeDto;
import com.inter.SistemaDeCadastro.models.InscricaoModalidadeModel;
import com.inter.SistemaDeCadastro.services.InscricaoModalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricaoModalidade")
@CrossOrigin("*")
public class InscricaoModalidadeController {

    @Autowired
    private InscricaoModalidadeService service;

    @PostMapping
    public InscricaoModalidadeModel criar(@RequestBody InscricaoModalidadeDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<InscricaoModalidadeModel> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public InscricaoModalidadeModel buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}
