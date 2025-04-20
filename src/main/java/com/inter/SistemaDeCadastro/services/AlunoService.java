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

    // Método para listar todos os alunos
    public List<AlunoModel> listarAlunos() {
        return alunoRepository.findAll();
    }

    // Método para criar um novo aluno
    public AlunoModel criarAluno(AlunoDto alunoDto, String createdBy) {
        // Verifica se o CPF já está cadastrado
        if (alunoRepository.existsByCpf(alunoDto.cpf())) {
            throw new EntityNotFoundException("CPF já cadastrado.");
        }

        // Verifica se o RG já está cadastrado
        if (alunoRepository.existsByRg(alunoDto.rg())) {
            throw new EntityNotFoundException("RG já cadastrado.");
        }

        AlunoModel aluno = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, aluno);

        EscolaridadeModel escolaridade = escolaridadeRepository
                .findById(alunoDto.codEscolaridade())
                .orElseThrow(() -> new EntityNotFoundException("Escolaridade não encontrada"));
        aluno.setEscolaridadeModel(escolaridade);

        // Passa o nome do usuário que criou o aluno
        aluno.setCreatedBy(createdBy);

        return alunoRepository.save(aluno);
    }

    // Método para buscar um aluno pelo ID
    public Optional<AlunoModel> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    // Método para atualizar os dados de um aluno
    public AlunoModel atualizarAluno(Long id, AlunoDto alunoDto, String createdBy) {
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        // Verifica se o CPF ou RG estão sendo alterados para valores já cadastrados
        if (!aluno.getCpf().equals(alunoDto.cpf()) && alunoRepository.existsByCpf(alunoDto.cpf())) {
            throw new EntityNotFoundException("CPF já cadastrado.");
        }

        if (!aluno.getRg().equals(alunoDto.rg()) && alunoRepository.existsByRg(alunoDto.rg())) {
            throw new EntityNotFoundException("RG já cadastrado.");
        }

        // Atualiza os dados do aluno
        BeanUtils.copyProperties(alunoDto, aluno);

        EscolaridadeModel escolaridade = escolaridadeRepository
                .findById(alunoDto.codEscolaridade())
                .orElseThrow(() -> new EntityNotFoundException("Escolaridade não encontrada"));
        aluno.setEscolaridadeModel(escolaridade);

        // Atualiza o campo 'createdBy' caso necessário
        aluno.setCreatedBy(createdBy);

        return alunoRepository.save(aluno);
    }

    // Método para deletar um aluno
    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}
