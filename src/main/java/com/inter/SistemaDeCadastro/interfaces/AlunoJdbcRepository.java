package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.controllers.dtos.views.AlunoPorModalidadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AlunoPorModalidadeDto> buscarTodosAlunosAtivosPorModalidade() {
        String sql = """
        SELECT CodAluno, Nm_Aluno, CodModalidade, StatusAluno, StatusModalidade
        FROM vw_Alunos_Por_Modalidade
    """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> new AlunoPorModalidadeDto(
                rs.getInt("CodAluno"),
                rs.getString("Nm_Aluno"),
                rs.getObject("CodModalidade", Integer.class), // caso possa ser null
                rs.getString("StatusAluno"),
                rs.getString("StatusModalidade")
        ));
    }
}

