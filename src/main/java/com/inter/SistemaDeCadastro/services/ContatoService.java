package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.ContatoDto;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.ContatoRepository;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.ContatoModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    AlunoRepository alunoRepository;

    public ContatoModel salvarContato(ContatoDto dto) {
        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        ContatoModel contato = new ContatoModel();
        contato.setResponsavelEmergencial(dto.responsavelEmergencial());
        contato.setTelefonePrincipal(dto.telefonePrincipal());
        contato.setTelefoneEmergencial(dto.telefoneEmergencial());
        contato.setEmail(dto.email());
        contato.setAluno(aluno);
        contato.setStatus(dto.status() != null ? dto.status() : "A");

        return contatoRepository.save(contato);
    }

    public List<ContatoModel> listarContatos() {
        return contatoRepository.findAll();
    }

    public Optional<ContatoModel> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public ContatoModel atualizarContato(Long id, ContatoDto dto) {
        ContatoModel contato = contatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado"));

        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        contato.setResponsavelEmergencial(dto.responsavelEmergencial());
        contato.setTelefonePrincipal(dto.telefonePrincipal());
        contato.setTelefoneEmergencial(dto.telefoneEmergencial());
        contato.setEmail(dto.email());
        contato.setAluno(aluno);
        contato.setStatus(dto.status());

        return contatoRepository.save(contato);
    }
}
