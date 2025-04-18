package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.EscolaridadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EscolaridadeRepository extends JpaRepository<EscolaridadeModel,Long> {
    // Buscar por nome da escolaridade
    Optional<EscolaridadeModel> findByNome(String nome);

    // Buscar todos com status ativo (A)
    List<EscolaridadeModel> findByStatus(String status);
}
