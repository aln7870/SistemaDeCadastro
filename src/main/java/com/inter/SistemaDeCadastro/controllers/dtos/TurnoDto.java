package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.Pattern;

public record TurnoDto(
        Long codTurno,

        String nmTurno,

        @Pattern(regexp = "[AI]") String status
) {}
