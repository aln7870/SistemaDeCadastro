package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDto(
        String cep,

        String rua,

        @NotBlank String bairro,

        @NotBlank String cidade,

        @NotNull short numero,

        @NotBlank String resideCom,

        String outroResideCom,

        @NotNull Integer codAluno,

        String status
) {
}
