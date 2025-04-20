package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.EscolaridadeDto;
import com.inter.SistemaDeCadastro.interfaces.EscolaridadeRepository;
import com.inter.SistemaDeCadastro.models.EscolaridadeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EscolaridadeService {

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    // Método para criar uma nova escolaridade
    public EscolaridadeDto criar(EscolaridadeDto escolaridadeDto) {
        EscolaridadeModel escolaridade = new EscolaridadeModel();
        // Convertendo DTO para Model
        escolaridade.setNm_Escolaridade(escolaridadeDto.nome());
        escolaridade.setStatus(escolaridadeDto.status());

        EscolaridadeModel novaEscolaridade = escolaridadeRepository.save(escolaridade);

        // Convertendo o Model de volta para DTO
        return new EscolaridadeDto(
                novaEscolaridade.getCodEscolaridade(),
                novaEscolaridade.getNm_Escolaridade(),
                novaEscolaridade.getStatus()
        );
    }

    // Método para listar todas as escolaridades
    public List<EscolaridadeDto> listarTodas() {
        List<EscolaridadeModel> escolaridades = escolaridadeRepository.findAll();
        return escolaridades.stream()
                .map(e -> new EscolaridadeDto(e.getCodEscolaridade(), e.getNm_Escolaridade(), e.getStatus()))
                .collect(Collectors.toList());
    }

    // Método para buscar escolaridade por ID
    public Optional<EscolaridadeDto> buscarPorId(Long id) {
        Optional<EscolaridadeModel> escolaridadeModel = escolaridadeRepository.findById(id);
        return escolaridadeModel.map(e -> new EscolaridadeDto(e.getCodEscolaridade(), e.getNm_Escolaridade(), e.getStatus()));
    }

    // Método para atualizar a escolaridade
    public EscolaridadeDto atualizar(Long id, EscolaridadeDto escolaridadeDto) {
        return escolaridadeRepository.findById(id)
                .map(e -> {
                    e.setNm_Escolaridade(escolaridadeDto.nome());
                    e.setStatus(escolaridadeDto.status());
                    EscolaridadeModel escolaridadeAtualizada = escolaridadeRepository.save(e);
                    return new EscolaridadeDto(
                            escolaridadeAtualizada.getCodEscolaridade(),
                            escolaridadeAtualizada.getNm_Escolaridade(),
                            escolaridadeAtualizada.getStatus()
                    );
                })
                .orElseThrow(() -> new RuntimeException("Escolaridade não encontrada"));
    }

    // Método para deletar a escolaridade
    public void deletar(Long id) {
        escolaridadeRepository.deleteById(id);
    }
}
