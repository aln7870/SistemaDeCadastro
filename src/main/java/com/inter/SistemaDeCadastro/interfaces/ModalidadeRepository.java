package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.ModalidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModalidadeRepository extends JpaRepository<ModalidadeModel,Long> {
    List<ModalidadeModel>findByStatus(String status);

}
