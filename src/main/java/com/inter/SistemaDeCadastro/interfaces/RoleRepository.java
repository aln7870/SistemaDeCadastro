package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel,Long> {
    RoleModel findByNome(String nome);
}
