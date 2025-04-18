package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository <AlunoModel,Long> {
    Optional<AlunoModel> findByNome(String nome);
}
