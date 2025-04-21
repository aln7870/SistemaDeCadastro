package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.TurnoDto;
import com.inter.SistemaDeCadastro.interfaces.TurnoRepository;
import com.inter.SistemaDeCadastro.models.TurnoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    public TurnoModel save(TurnoDto dto) {
        TurnoModel model = new TurnoModel();
        model.setNome(dto.nome());
        return repository.save(model);
    }

    public List<TurnoModel> findAll() {
        return repository.findAll();
    }

    public TurnoModel findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public TurnoModel update(Integer id, TurnoDto dto) {
        TurnoModel model = repository.findById(id).orElse(null);
        if (model != null) {
            model.setNome(dto.nome());
            model.setStatus(dto.status());
            return repository.save(model);
        }
        return null;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
