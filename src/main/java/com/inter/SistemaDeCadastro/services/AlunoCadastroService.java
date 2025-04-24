package com.inter.SistemaDeCadastro.services;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoCadastroDto;
import com.inter.SistemaDeCadastro.interfaces.AlunoCadastroJdbcRepository;
import com.inter.SistemaDeCadastro.interfaces.EscolaridadeRepository;
import com.inter.SistemaDeCadastro.interfaces.TurnoRepository;
import com.inter.SistemaDeCadastro.models.*;
import com.inter.SistemaDeCadastro.models.enums.NacionalidadeAlunoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service

public class AlunoCadastroService {

        @Autowired
        private AlunoCadastroJdbcRepository alunoCadastroJdbcRepository;
            public void cadastrarAlunoCompleto(AlunoCadastroDto dto) {
            alunoCadastroJdbcRepository.cadastrarAluno(dto);
        }
}


