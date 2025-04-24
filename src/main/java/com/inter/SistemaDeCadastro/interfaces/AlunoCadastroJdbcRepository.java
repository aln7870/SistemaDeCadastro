package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoCadastroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class AlunoCadastroJdbcRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        public void cadastrarAluno(AlunoCadastroDto dto) {
            String sql = "CALL sp_Cadastro_Aluno(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(sql,
                    dto.nomeAluno(),
                    Date.valueOf(dto.dataNascimento()),
                    dto.sexo(),
                    dto.cpf(),
                    dto.rg(),
                    dto.nacionalidade(),
                    dto.codEscolaridade(),
                    dto.codUsuario(),
                    dto.cep(),
                    dto.rua(),
                    dto.bairro(),
                    dto.cidade(),
                    dto.numero(),
                    dto.resideCom(),
                    dto.outroResideCom(),
                    dto.responsavelEmergencial(),
                    dto.telefonePrincipal(),
                    dto.telefoneEmergencial(),
                    dto.email(),
                    dto.descricaoAlergia(),
                    dto.descricaoMedicacao(),
                    dto.descricaoProblemaSaude(),
                    dto.tipoDeficienca(),
                    dto.nomeFamiliar(),
                    Date.valueOf(dto.dataNascimentoFamiliar()),
                    dto.parentesco(),
                    dto.codEscolaridadeFamiliar(),
                    dto.codOcupacaoFamiliar(),
                    dto.codModalidade(),
                    dto.codTurno()
            );
        }
    }


