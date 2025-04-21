package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record InscricaoModalidadeDto(
        @NotNull Integer codAluno,

        @NotNull Integer codModalidade,

        @NotNull Integer codTurno
) {}
