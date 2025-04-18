package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EndereçoRepository extends JpaRepository<EnderecoModel,Long> {
    List<EnderecoModel> findByAlunoCodAluno(Long codAluno);

}
