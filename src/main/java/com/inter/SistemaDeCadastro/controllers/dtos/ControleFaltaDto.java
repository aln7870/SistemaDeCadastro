package com.inter.SistemaDeCadastro.controllers.dtos;

import com.inter.SistemaDeCadastro.models.enums.TipoFaltaEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.sql.Date;

public record ControleFaltaDto(

        @Pattern(regexp = "[PF]") String falta,

        @NotNull Date dataFalta,

        @NotNull Integer codAluno,

        @NotNull Integer codInscricaoModalidade,

        TipoFaltaEnum tipoFalta,

        @Pattern(regexp = "[AI]") String status
) {}
