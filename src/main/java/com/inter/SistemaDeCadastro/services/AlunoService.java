package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoDto;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.EscolaridadeRepository;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.EscolaridadeModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    public List<AlunoModel> listarAlunos() {
        return alunoRepository.findAll();
    }

    public AlunoModel criarAluno(AlunoDto alunoDto) {
        AlunoModel aluno = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, aluno);

        EscolaridadeModel escolaridade = escolaridadeRepository
                .findById(alunoDto.codEscolaridade())
                .orElseThrow(() -> new EntityNotFoundException("Escolaridade não encontrada"));

        aluno.setEscolaridadeModel(escolaridade);
        return alunoRepository.save(aluno);
    }

    public Optional<AlunoModel> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public AlunoModel atualizarAluno(Long id, AlunoDto alunoDto) {
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        BeanUtils.copyProperties(alunoDto, aluno);

        EscolaridadeModel escolaridade = escolaridadeRepository
                .findById(alunoDto.codEscolaridade())
                .orElseThrow(() -> new EntityNotFoundException("Escolaridade não encontrada"));

        aluno.setEscolaridadeModel(escolaridade);
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}
