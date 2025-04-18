package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.ControleFaltaModel;
import com.inter.SistemaDeCadastro.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ControleFaltaRepository extends JpaRepository<ControleFaltaModel,Long> {
    List<ControleFaltaModel> findByUser(UserModel user);

}
