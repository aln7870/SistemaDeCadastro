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

import com.inter.SistemaDeCadastro.models.enums.ParentescoEnum;
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
        familiar.setNmFamiliar(dto.nmFamiliar());
        familiar.setDtNascimento(dto.dtNascimento());
        familiar.setStatus(dto.status());

        // Converte o campo 'parentesco' para o enum
        ParentescoEnum parentesco = ParentescoEnum.from(dto.parentesco());
        familiar.setParentesco(parentesco);  // Define o parentesco no familiar

        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        OcupacaoModel ocupacao = ocupacaoRepository.findById(dto.codOcupacao())
                .orElseThrow(() -> new RuntimeException("Ocupação não encontrada"));

        EscolaridadeModel escolaridade = escolaridadeRepository.findById(dto.codEscolaridade())
                .orElseThrow(() -> new RuntimeException("Escolaridade não encontrada"));

        familiar.setAluno(aluno);
        familiar.setOcupacao(ocupacao);
        familiar.setEscolaridade(escolaridade);

        return familiarRepository.save(familiar);
    }

    public List<FamiliarModel> listarTodos() {
        return familiarRepository.findAll();
    }

    public FamiliarModel atualizar(Long id, FamiliarDto dto) {
        FamiliarModel familiar = familiarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familiar não encontrado"));

        familiar.setNmFamiliar(dto.nmFamiliar());
        familiar.setDtNascimento(dto.dtNascimento());
        familiar.setStatus(dto.status());

        // Converte novamente o parentesco para o enum
        ParentescoEnum parentesco = ParentescoEnum.from(dto.parentesco());
        familiar.setParentesco(parentesco);

        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        OcupacaoModel ocupacao = ocupacaoRepository.findById(dto.codOcupacao())
                .orElseThrow(() -> new RuntimeException("Ocupação não encontrada"));
        EscolaridadeModel escolaridade = escolaridadeRepository.findById(dto.codEscolaridade())
                .orElseThrow(() -> new RuntimeException("Escolaridade não encontrada"));

        familiar.setAluno(aluno);
        familiar.setOcupacao(ocupacao);
        familiar.setEscolaridade(escolaridade);

        return familiarRepository.save(familiar);
    }

    public void deletar(Long id) {
        familiarRepository.deleteById(id);
    }

    public FamiliarModel buscarPorId(Long id) {
        return familiarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familiar não encontrado"));
    }
}
