package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record EscolaridadeDto(
        Integer codEscolaridade,
        @NotBlank String nome,
        String status
) {
}
