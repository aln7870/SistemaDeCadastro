package com.inter.SistemaDeCadastro.controllers;

import com.inter.SistemaDeCadastro.controllers.dtos.TurnoDto;
import com.inter.SistemaDeCadastro.models.TurnoModel;
import com.inter.SistemaDeCadastro.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @PostMapping
    public TurnoModel create(@RequestBody TurnoDto dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<TurnoModel> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TurnoModel getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public TurnoModel update(@PathVariable Long id, @RequestBody TurnoDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
