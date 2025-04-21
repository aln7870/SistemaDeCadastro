package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.Pattern;

public record TurnoDto(
        String nome,
        String status
) {}
