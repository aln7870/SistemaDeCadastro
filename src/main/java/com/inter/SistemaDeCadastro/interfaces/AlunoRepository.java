package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.controllers.dtos.views.AlunoPorModalidadeDto;
import com.inter.SistemaDeCadastro.models.AlunoModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository <AlunoModel,Integer> {
    Optional<AlunoModel> findByNome(String nome);
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
}