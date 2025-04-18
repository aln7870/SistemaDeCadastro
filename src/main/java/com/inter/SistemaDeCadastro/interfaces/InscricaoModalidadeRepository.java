package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.models.InscricaoModalidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscricaoModalidadeRepository extends JpaRepository<InscricaoModalidadeModel,Long> {

    List<InscricaoModalidadeModel> findByAlunoCodAluno(Long codAluno);
    List<InscricaoModalidadeModel> findByModalidadeCodModalidade(Long codModalidade);
    List<InscricaoModalidadeModel> findByTurnoCodTurno(Long codTurno);
}
