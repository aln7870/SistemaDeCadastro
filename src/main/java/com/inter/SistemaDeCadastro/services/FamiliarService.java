package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.FamiliarDto;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.EscolaridadeRepository;
import com.inter.SistemaDeCadastro.interfaces.FamiliarRepository;
import com.inter.SistemaDeCadastro.interfaces.OcupacaoRepository;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.EscolaridadeModel;
import com.inter.SistemaDeCadastro.models.FamiliarModel;
import com.inter.SistemaDeCadastro.models.OcupacaoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarService {

    @Autowired
    private FamiliarRepository familiarRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private OcupacaoRepository ocupacaoRepository;

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    public FamiliarModel criar(FamiliarDto dto) {
        FamiliarModel familiar = new FamiliarModel();
        familiar.setNome(dto.nome());
        familiar.setDataNasc(dto.dataNasc());
        familiar.setStatus(dto.status());
        familiar.setParentesco(dto.parentesco());


        AlunoModel aluno = alunoRepository.findById(dto.aluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        OcupacaoModel ocupacao = ocupacaoRepository.findById(dto.ocupacao())
                .orElseThrow(() -> new RuntimeException("Ocupação não encontrada"));

        EscolaridadeModel escolaridade = escolaridadeRepository.findById(dto.escolaridade())
                .orElseThrow(() -> new RuntimeException("Escolaridade não encontrada"));

        familiar.setAluno(aluno);
        familiar.setOcupacao(ocupacao);
        familiar.setEscolaridade(escolaridade);

        return familiarRepository.save(familiar);
    }

    public List<FamiliarModel> listarTodos() {
        return familiarRepository.findAll();
    }

    public FamiliarModel atualizar(Integer id, FamiliarDto dto) {
        FamiliarModel familiar = familiarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familiar não encontrado"));

        familiar.setNome(dto.nome());
        familiar.setDataNasc(dto.dataNasc());
        familiar.setStatus(dto.status());
        familiar.setParentesco(dto.parentesco());

        AlunoModel aluno = alunoRepository.findById(dto.aluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        OcupacaoModel ocupacao = ocupacaoRepository.findById(dto.ocupacao())
                .orElseThrow(() -> new RuntimeException("Ocupação não encontrada"));
        EscolaridadeModel escolaridade = escolaridadeRepository.findById(dto.escolaridade())
                .orElseThrow(() -> new RuntimeException("Escolaridade não encontrada"));

        familiar.setAluno(aluno);
        familiar.setOcupacao(ocupacao);
        familiar.setEscolaridade(escolaridade);

        return familiarRepository.save(familiar);
    }

    public void deletar(Integer id) {
        familiarRepository.deleteById(id);
    }

    public FamiliarModel buscarPorId(Integer id) {
        return familiarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familiar não encontrado"));
    }
}
