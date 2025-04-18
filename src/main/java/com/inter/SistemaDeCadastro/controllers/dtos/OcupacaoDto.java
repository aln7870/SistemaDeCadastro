package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record OcupacaoDto(
        Long codOcupacao,

        @NotBlank String nmModalidade,

        @Pattern(regexp = "[AI]") String status
) {}
