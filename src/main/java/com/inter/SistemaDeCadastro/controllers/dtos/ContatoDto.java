package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ContatoDto(
        Long codContato,

        @NotBlank String responsavelEmergencial,

        @NotBlank String telefonePrincipal,

        @NotBlank String telefoneEmergencial,

        @NotBlank @Email String email,

        @NotNull Long codAluno,

        @Pattern(regexp = "[AI]") String status
) {}
