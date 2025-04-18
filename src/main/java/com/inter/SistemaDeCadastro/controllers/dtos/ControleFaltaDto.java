package com.inter.SistemaDeCadastro.controllers.dtos;

import com.inter.SistemaDeCadastro.models.enums.StatusFaltaEnum;
import com.inter.SistemaDeCadastro.models.enums.TipoFaltaEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.sql.Date;

public record ControleFaltaDto(
        Long codControleFalta,

        @Pattern(regexp = "[PF]") String falta,

        @NotNull Date dataFalta,

        @NotNull Long codUsuario,

        @NotNull Long codInscricaoModalidade,

        StatusFaltaEnum statusFalta,

        TipoFaltaEnum tipoFalta,

        @Pattern(regexp = "[AI]") String status
) {}
