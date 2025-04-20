package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Date;

public record FamiliarDto(
        Long codFamiliar,

        @NotBlank String nmFamiliar,

        @NotNull Date dtNascimento,

        @NotNull Long codAluno,

        @NotNull Long codOcupacao,

        @NotNull Long codEscolaridade,

        @NotBlank String parentesco,

        @Pattern(regexp = "[AI]") String status
) {}
