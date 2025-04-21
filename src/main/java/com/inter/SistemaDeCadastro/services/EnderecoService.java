package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.EnderecoDto;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.EnderecoModel;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public EnderecoModel salvar(EnderecoDto dto) {
        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com ID: " + dto.codAluno()));

        EnderecoModel endereco = new EnderecoModel();
        BeanUtils.copyProperties(dto, endereco);
         endereco.setAluno(aluno);

        return enderecoRepository.save(endereco);
    }

    public List<EnderecoModel> listarTodos() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel buscarPorId(Integer id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
    }

    public EnderecoModel atualizar(Integer id, EnderecoDto dto) {
        EnderecoModel endereco = buscarPorId(id);

        endereco.setCep(dto.cep());
        endereco.setRua(dto.rua());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setNumero(dto.numero());
        endereco.setResideCom(dto.resideCom());
        endereco.setOutroResideCom(dto.outroResideCom());
        endereco.setStatus(dto.status());

        return enderecoRepository.save(endereco);
    }

    public void deletar(Integer id) {
        EnderecoModel endereco = buscarPorId(id);
        enderecoRepository.delete(endereco);
    }
}
