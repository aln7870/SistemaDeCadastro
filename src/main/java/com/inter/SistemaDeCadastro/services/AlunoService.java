package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoDto;
import com.inter.SistemaDeCadastro.controllers.dtos.AlunoResponseDto;
import com.inter.SistemaDeCadastro.controllers.dtos.views.AlunoPorModalidadeDto;
import com.inter.SistemaDeCadastro.interfaces.AlunoJdbcRepository;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.EscolaridadeRepository;
import com.inter.SistemaDeCadastro.interfaces.UserRepository;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.EscolaridadeModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AlunoJdbcRepository alunoJdbcRepository;

    // Método para listar todos os alunos
    public List<AlunoResponseDto> listarAlunos() {
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos.stream().map(this::mapToAlunoResponseDto).collect(Collectors.toList());
    }

    private AlunoResponseDto mapToAlunoResponseDto(AlunoModel aluno) {
        if (aluno == null) {
            return null;
        }
        // Pega o ID do usuário criador (se existir)
        Integer criadorId = (aluno.getCodUsuario() != null) ? aluno.getCodUsuario().getIdUsuario() : null; // Ajuste getter se necessário
        // Pega o ID da escolaridade (se existir)
        Integer escolaridadeId = (aluno.getEscolaridadeModel() != null) ? aluno.getEscolaridadeModel().getCodEscolaridade() : null; // Ajuste getter se necessário

        return new AlunoResponseDto(
                aluno.getCodAluno(), // <<< ID do aluno salvo
                aluno.getNome(),
                aluno.getDataNasc(), // Usar dados do objeto 'aluno'
                aluno.getSexo(),
                aluno.getCpf(),
                aluno.getRg(),
                aluno.getNacionalidade(),
                escolaridadeId, // ID da escolaridade associada
                aluno.getStatus(),
                criadorId // ID do usuário criador
        );
    }


    // Método para criar um novo aluno
    @Transactional
    public AlunoResponseDto criarAluno(AlunoDto alunoDto, Integer createdBy) {
        if (alunoDto.cpf() == null && alunoDto.rg() == null) {
            throw new IllegalArgumentException("Campos CPF ou RG nulos ou inválidos");
        }

        // Verifica se o CPF já está cadastrado
        if (alunoRepository.existsByCpf(alunoDto.cpf())) {
            throw new EntityNotFoundException("CPF já cadastrado.");
        }

        // Verifica se o RG já está cadastrado
        if (alunoRepository.existsByRg(alunoDto.rg())) {
            throw new EntityNotFoundException("RG já cadastrado.");
        }

        UserModel criador = userRepository.findById(createdBy)
                .orElseThrow(() -> new EntityNotFoundException("Usuário criador não encontrado com ID: " + createdBy)); // Mensagem mais específica

        EscolaridadeModel escolaridade = escolaridadeRepository
                .findById(alunoDto.codEscolaridade())
                .orElseThrow(() -> new EntityNotFoundException("Escolaridade não encontrada"));

        AlunoModel aluno = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, aluno);
        aluno.setEscolaridadeModel(escolaridade);
        aluno.setCodUsuario(criador);

        AlunoModel alunosalvo = alunoRepository.save(aluno);
        return mapToAlunoResponseDto(alunosalvo);
    }

    // Método para buscar um aluno pelo ID
    public Optional<AlunoModel> buscarAlunoPorId(Integer id) {
        return alunoRepository.findById(id);
    }

    // Método para atualizar os dados de um aluno
    public AlunoResponseDto atualizarAluno(Integer id, AlunoDto alunoDto) {
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        if (alunoDto.cpf() == null && alunoDto.rg() == null) {
            throw new IllegalArgumentException("Campos CPF ou RG nulos ou inválidos");
        }


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

        AlunoModel alunoAtualizado = alunoRepository.save(aluno);
        return mapToAlunoResponseDto(alunoAtualizado);
    }

    // Método para deletar um aluno
    @Transactional
    public void deletarAluno(Integer id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }
}
