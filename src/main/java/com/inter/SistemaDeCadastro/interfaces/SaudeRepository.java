package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.SaudeModel;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface SaudeRepository extends JpaRepository<SaudeModel,Long> {
}
