
package com.inter.SistemaDeCadastro.interfaces;


import com.inter.SistemaDeCadastro.controllers.dtos.views.ListaPresencaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PresencaJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ListaPresencaDto> buscarPresencasFiltradas(Integer codModalidade, Integer codTurno, java.time.LocalDate dataFalta) {
        String sql = "CALL sp_Controle_Presenca(?, ?, ?)";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(
                sql,
                codModalidade,
                codTurno,
                dataFalta != null ? Date.valueOf(dataFalta) : null
        );

        return result.stream().map(row -> new ListaPresencaDto(
                row.get("CodAluno") != null ? ((Number) row.get("CodAluno")).intValue() : null,
                (String) row.get("NomeAluno"),
                (String) row.get("Presenca"),
                row.get("CodModalidade") != null ? ((Number) row.get("CodModalidade")).intValue() : null,
                row.get("CodTurno") != null ? ((Number) row.get("CodTurno")).intValue() : null,
                row.get("DataFalta") != null ? ((Date) row.get("DataFalta")).toLocalDate() : null,
                row.get("CodInscricaoModalidade") != null ? ((Number) row.get("CodInscricaoModalidade")).intValue() : null
        )).toList();
    }
}
