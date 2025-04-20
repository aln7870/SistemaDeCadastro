package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.ModalidadeDto;
import com.inter.SistemaDeCadastro.interfaces.ModalidadeRepository;
import com.inter.SistemaDeCadastro.models.ModalidadeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadeService {

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    public ModalidadeModel criar(ModalidadeDto dto) {
        ModalidadeModel modalidade = new ModalidadeModel();
        modalidade.setNm_Modalidade(dto.nmModalidade());
        modalidade.setStatus(dto.status());
        return modalidadeRepository.save(modalidade);
    }

    public List<ModalidadeModel> listarTodas() {
        return modalidadeRepository.findAll();
    }

    public Optional<ModalidadeModel> buscarPorId(Long id) {
        return modalidadeRepository.findById(id);
    }

    public ModalidadeModel atualizar(Long id, ModalidadeDto dto) {
        return modalidadeRepository.findById(id)
                .map(m -> {
                    m.setNm_Modalidade(dto.nmModalidade());
                    m.setStatus(dto.status());
                    return modalidadeRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Modalidade não encontrada"));
    }

    public void deletar(Long id) {
        modalidadeRepository.deleteById(id);
    }
}
