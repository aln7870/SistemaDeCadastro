package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.OcupacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcupacaoRepository extends JpaRepository<OcupacaoModel,Long> {
}
