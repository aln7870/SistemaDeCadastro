package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDto(
        Long codEndereco,

        @NotBlank String cep,

        @NotBlank String rua,

        @NotBlank String bairro,

        @NotBlank String cidade,

        @NotNull short numero,

        @NotBlank String resideCom,

        @NotBlank String outroResideCom,

        @NotNull Long codAluno,

        @Pattern(regexp = "[AI]") String status
) {}
