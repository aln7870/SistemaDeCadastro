package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.FamiliarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamiliarRepository extends JpaRepository<FamiliarModel,Integer> {
    List<FamiliarModel> findByAlunoCodAluno(Integer codAluno);
    List<FamiliarModel> findByStatus(String status);
}
