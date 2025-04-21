package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record OcupacaoDto(

        @NotBlank String nmModalidade,

        String status
) {
}
