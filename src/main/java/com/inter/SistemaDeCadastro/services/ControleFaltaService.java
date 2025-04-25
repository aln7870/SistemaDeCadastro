package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.ControleFaltaDto;
import com.inter.SistemaDeCadastro.controllers.dtos.MarcarFaltaDto;
import com.inter.SistemaDeCadastro.interfaces.ControleFaltaJdbcRepository;
import com.inter.SistemaDeCadastro.interfaces.ControleFaltaRepository;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository; // Alterado para AlunoRepository
import com.inter.SistemaDeCadastro.interfaces.InscricaoModalidadeRepository;
import com.inter.SistemaDeCadastro.models.ControleFaltaModel;
import com.inter.SistemaDeCadastro.models.AlunoModel; // Alterado para AlunoModel
import com.inter.SistemaDeCadastro.models.InscricaoModalidadeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ControleFaltaService {

    @Autowired
    private ControleFaltaRepository controleFaltaRepository;

    @Autowired
    private AlunoRepository alunoRepository; // Alterado para AlunoRepository

    @Autowired
    private InscricaoModalidadeRepository inscricaoModalidadeRepository;

    @Autowired
    private ControleFaltaJdbcRepository repository;

    public List<ControleFaltaModel> listarTodos() {
        return controleFaltaRepository.findAll();
    }

    public Optional<ControleFaltaModel> buscarPorId(Integer id) {
        return controleFaltaRepository.findById(id);
    }

    public ControleFaltaModel criar(ControleFaltaDto dto) {
        ControleFaltaModel model = new ControleFaltaModel();
        BeanUtils.copyProperties(dto, model, "aluno", "inscricaoModalidade");// Alterado para aluno

        AlunoModel aluno = alunoRepository.findById(dto.codAluno()) // Alterado para buscar por Aluno
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        InscricaoModalidadeModel inscricao = inscricaoModalidadeRepository.findById(dto.codInscricaoModalidade())
                .orElseThrow(() -> new RuntimeException("Inscrição de modalidade não encontrada"));

        // model.setAluno(aluno); // Alterado para setar AlunoModel
        model.setInscricaoModalidade(inscricao);

        return controleFaltaRepository.save(model);
    }

    public void marcarFalta(MarcarFaltaDto dto) {
        if (dto.codInscricaoModalidade() == null || dto.dataFalta() == null) {
            throw new IllegalArgumentException("Código da inscrição e data da falta são obrigatórios.");
        }

        repository.marcarFalta(dto.codInscricaoModalidade(), dto.dataFalta());
    }

    public ControleFaltaModel atualizar(Integer id, ControleFaltaDto dto) {
        ControleFaltaModel model = controleFaltaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controle de falta não encontrado"));

        BeanUtils.copyProperties(dto, model, "codControleFalta", "aluno", "inscricaoModalidade"); // Alterado para aluno

        AlunoModel aluno = alunoRepository.findById(dto.codAluno()) // Alterado para buscar por Aluno
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        InscricaoModalidadeModel inscricao = inscricaoModalidadeRepository.findById(dto.codInscricaoModalidade())
                .orElseThrow(() -> new RuntimeException("Inscrição de modalidade não encontrada"));

        // model.setAluno(aluno); // Alterado para setar AlunoModel
        model.setInscricaoModalidade(inscricao);

        return controleFaltaRepository.save(model);
    }
}
