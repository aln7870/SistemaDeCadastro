package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.OcupacaoDto;
import com.inter.SistemaDeCadastro.interfaces.OcupacaoRepository;
import com.inter.SistemaDeCadastro.models.OcupacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcupacaoService {

    @Autowired
    private OcupacaoRepository ocupacaoRepository;

    public OcupacaoModel criar(OcupacaoDto dto) {
        OcupacaoModel ocupacao = new OcupacaoModel();
        ocupacao.setNm_Modalidade(dto.nmModalidade());
        ocupacao.setStatus(dto.status());
        return ocupacaoRepository.save(ocupacao);
    }

    public List<OcupacaoModel> listarTodas() {
        return ocupacaoRepository.findAll();
    }

    public Optional<OcupacaoModel> buscarPorId(Long id) {
        return ocupacaoRepository.findById(id);
    }

    public OcupacaoModel atualizar(Long id, OcupacaoDto dto) {
        return ocupacaoRepository.findById(id)
                .map(o -> {
                    o.setNm_Modalidade(dto.nmModalidade());
                    o.setStatus(dto.status());
                    return ocupacaoRepository.save(o);
                })
                .orElseThrow(() -> new RuntimeException("Ocupação não encontrada"));
    }

    public void deletar(Long id) {
        ocupacaoRepository.deleteById(id);
    }
}
