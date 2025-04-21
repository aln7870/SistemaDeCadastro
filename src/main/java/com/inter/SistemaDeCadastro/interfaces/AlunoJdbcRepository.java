package com.inter.SistemaDeCadastro.interfaces;

import com.inter.SistemaDeCadastro.controllers.dtos.views.AlunoPorModalidadeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AlunoJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método existente para buscar todos os alunos ativos por modalidade
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
/*
    // Novo método para chamar a stored procedure
    public List<AlunoPorModalidadeDto> filtrarAlunosPorModalidade(String nomeAluno, Integer codModalidade) {
        // SQL para chamar a stored procedure
        String sql = "CALL sp_Filtrar_Alunos_Por_Modalidade(?, ?)";

        // Chama a stored procedure e mapeia os resultados para o DTO
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, nomeAluno, codModalidade);

        // Converte o resultado para o DTO AlunoPorModalidadeDto
        return result.stream().map(row -> new AlunoPorModalidadeDto(
                (Integer) row.get("CodAluno"), // Certifique-se de que CodAluno é Integer
                (String) row.get("Nm_Aluno"),  // Nome do aluno
                row.get("CodModalidade") != null ? (Integer) row.get("CodModalidade") : null, // Tratando o valor null
                (String) row.get("StatusAluno"),
                (String) row.get("StatusModalidade")
        )).toList();
    }*/
}
