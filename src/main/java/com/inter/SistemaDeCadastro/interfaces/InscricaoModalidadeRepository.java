package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.InscricaoModalidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscricaoModalidadeRepository extends JpaRepository<InscricaoModalidadeModel,Integer> {

    List<InscricaoModalidadeModel> findByAlunoCodAluno(Integer codAluno);
    List<InscricaoModalidadeModel> findByModalidadeCodModalidade(Integer codModalidade);
    List<InscricaoModalidadeModel> findByTurnoCodTurno(Integer codTurno);
}
