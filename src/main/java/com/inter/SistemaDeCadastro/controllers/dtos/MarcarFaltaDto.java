package com.inter.SistemaDeCadastro.controllers.dtos;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MarcarFaltaDto(
        @NotNull Integer codInscricaoModalidade,
        @NotNull LocalDate dataFalta
) {}
