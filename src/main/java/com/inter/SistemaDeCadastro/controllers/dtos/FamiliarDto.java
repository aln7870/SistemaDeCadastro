package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record FamiliarDto(
        @NotBlank String nome,

        @NotBlank Date dataNasc,

        @NotNull Integer aluno,

        @NotNull Integer ocupacao,

        @NotNull Integer escolaridade,

        @NotBlank String parentesco,

        String status
) {
}
