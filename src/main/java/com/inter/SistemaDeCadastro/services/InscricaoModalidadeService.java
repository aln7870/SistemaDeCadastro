package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.InscricaoModalidadeDto;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.ModalidadeModel;
import com.inter.SistemaDeCadastro.models.TurnoModel;
import com.inter.SistemaDeCadastro.models.InscricaoModalidadeModel;
import com.inter.SistemaDeCadastro.interfaces.InscricaoModalidadeRepository;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.ModalidadeRepository;
import com.inter.SistemaDeCadastro.interfaces.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoModalidadeService {

    @Autowired
    private InscricaoModalidadeRepository inscricaoModalidadeRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @Autowired
    private TurnoRepository turnoRepository;

    public InscricaoModalidadeModel criar(InscricaoModalidadeDto dto) {
        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        ModalidadeModel modalidade = modalidadeRepository.findById(dto.codModalidade())
                .orElseThrow(() -> new RuntimeException("Modalidade não encontrada"));

        TurnoModel turno = turnoRepository.findById(dto.codTurno())
                .orElseThrow(() -> new RuntimeException("Turno não encontrado"));

        InscricaoModalidadeModel inscricao = new InscricaoModalidadeModel();
        inscricao.setAluno(aluno);
        inscricao.setModalidade(modalidade);
        inscricao.setTurno(turno);

        return inscricaoModalidadeRepository.save(inscricao);
    }

    public List<InscricaoModalidadeModel> listarTodas() {
        return inscricaoModalidadeRepository.findAll();
    }

    public Optional<InscricaoModalidadeModel> buscarPorId(Integer id) {
        return inscricaoModalidadeRepository.findById(id);
    }

    public void deletar(Integer id) {
        inscricaoModalidadeRepository.deleteById(id);
    }
}
