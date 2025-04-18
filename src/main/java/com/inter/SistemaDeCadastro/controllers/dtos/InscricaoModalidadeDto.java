package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record InscricaoModalidadeDto(
        Long codInscricaoModalidade,

        @NotNull Long codAluno,

        @NotNull Long codModalidade,

        @NotNull Long codTurno
) {}
