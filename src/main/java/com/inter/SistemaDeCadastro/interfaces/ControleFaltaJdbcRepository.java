package com.inter.SistemaDeCadastro.interfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

    @Repository
    public class ControleFaltaJdbcRepository {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        public void marcarFalta(Integer codInscricaoModalidade, LocalDate dataFalta) {
            String sql = "CALL sp_Marcar_Falta_Aluno(?, ?)";
            jdbcTemplate.update(sql, codInscricaoModalidade, Date.valueOf(dataFalta));
        }
    }


