package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<ContatoModel,Long> {
    List<ContatoModel> findByAluno(AlunoModel aluno);
    List<ContatoModel> findByStatus(String status);
}
