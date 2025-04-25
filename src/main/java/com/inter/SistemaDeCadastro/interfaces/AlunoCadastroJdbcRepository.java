package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.controllers.dtos.AlunoCadastroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class AlunoCadastroJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName(); // Obtém o usuário logado
    }

    public void cadastrarAluno(AlunoCadastroDto dto) {
        // Obtém o codUsuario do usuário logado (se necessário)
        String createdBy = getLoggedInUsername();
        var codUser = Integer.parseInt(createdBy);  // Supondo que o username seja o ID do usuário logado

        // SQL para chamar a stored procedure
        String sql = "CALL sp_Cadastro_Aluno(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Passando os parâmetros para o procedimento
        jdbcTemplate.update(sql,
                dto.nomeAluno(),                             // p_Nm_Aluno
                Date.valueOf(dto.dataNascimento()),          // p_Dt_Nascimento
                dto.sexo(),                                  // p_Sexo
                dto.cpf(),                                   // p_CPF
                dto.rg(),                                    // p_RG
                dto.nacionalidade(),                         // p_Nacionalidade
                dto.codEscolaridade(),                       // p_CodEscolaridade
                codUser,                                     // p_CodUsuario
                dto.cep(),                                   // p_CEP
                dto.rua(),                                   // p_Rua
                dto.bairro(),                                // p_Bairro
                dto.cidade(),                                // p_Cidade
                dto.numero(),                                // p_Numero
                dto.resideCom(),                             // p_ResideCom
                dto.outroResideCom(),                        // p_OutroResideCom
                dto.responsavelEmergencial(),                // p_ResponsavelEmergencial
                dto.telefonePrincipal(),                     // p_TelefonePrincipal
                dto.telefoneEmergencial(),                   // p_TelefoneEmergencial
                dto.email(),                                 // p_Email
                dto.descricaoAlergia(),                      // p_DescricaoAlergia
                dto.descricaoMedicacao(),                    // p_DescricaoMedicacao
                dto.descricaoProblemaSaude(),                // p_DescricaoProblemaSaude
                dto.tipoDeficienca(),                        // p_TipoDeficienca
                dto.nomeFamiliar(),                          // p_Nm_Familiar
                Date.valueOf(dto.dataNascimentoFamiliar()),  // p_Dt_Nascimento_Familiar
                dto.parentesco(),                            // p_Parentesco
                dto.codEscolaridadeFamiliar(),               // p_CodEscolaridade_Familiar
                dto.codOcupacaoFamiliar(),                   // p_CodOcupacao_Familiar
                dto.codModalidade(),                         // p_CodModalidade
                dto.codTurno()                               // p_CodTurno
        );
    }

}
