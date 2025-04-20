package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.SaudeDto;
import com.inter.SistemaDeCadastro.interfaces.AlunoRepository;
import com.inter.SistemaDeCadastro.interfaces.SaudeRepository;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.SaudeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaudeService {

    @Autowired
    private SaudeRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public SaudeModel save(SaudeDto dto) {
        SaudeModel model = new SaudeModel();
        model.setDescricaoAlergia(dto.descricaoAlergia());
        model.setDescricaoMedicacao(dto.descricaoMedicacao());
        model.setDescricaoProblemaSaude(dto.descricaoProblemaSaude());
        model.setTipoDeficiencia(dto.tipoDeficiencia());
        model.setStatus(dto.status() != null ? dto.status() : "A");

        // Vinculando o aluno
        AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        model.setAluno(aluno);

        return repository.save(model);
    }

    public List<SaudeModel> findAll() {
        return repository.findAll();
    }

    public SaudeModel findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public SaudeModel update(Long id, SaudeDto dto) {
        SaudeModel model = repository.findById(id).orElse(null);
        if (model != null) {
            model.setDescricaoAlergia(dto.descricaoAlergia());
            model.setDescricaoMedicacao(dto.descricaoMedicacao());
            model.setDescricaoProblemaSaude(dto.descricaoProblemaSaude());
            model.setTipoDeficiencia(dto.tipoDeficiencia());
            model.setStatus(dto.status());

            // Vinculando novamente o aluno, caso seja alterado
            AlunoModel aluno = alunoRepository.findById(dto.codAluno())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
            model.setAluno(aluno);

            return repository.save(model);
        }
        return null;
    }
}
