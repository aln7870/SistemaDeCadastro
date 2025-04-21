package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ContatoDto(

        @NotBlank String responsavelEmergencial,

        @NotBlank String telefonePrincipal,

        @NotBlank String telefoneEmergencial,

        @NotBlank String email,

        @NotNull Integer codAluno,

        String status
) {}
