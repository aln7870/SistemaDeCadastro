package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.TurnoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<TurnoModel,Integer> {
}
