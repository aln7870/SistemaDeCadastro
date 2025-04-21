package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.SaudeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SaudeRepository extends JpaRepository<SaudeModel,Integer> {
    List<SaudeModel> findByAluno(AlunoModel aluno);

}
