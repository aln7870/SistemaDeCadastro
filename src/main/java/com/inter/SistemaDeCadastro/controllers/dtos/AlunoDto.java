package com.inter.SistemaDeCadastro.controllers.dtos;

import com.inter.SistemaDeCadastro.models.enums.NacionalidadeAlunoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Date;
import java.time.LocalDateTime;

public record AlunoDto(
        Long codAluno,
        @NotBlank String nome,
        @NotNull Date dataNasc,
        @Pattern(regexp = "[MF]") String sexo,
        @NotBlank String cpf,
        @NotBlank String rg,
        NacionalidadeAlunoEnum nacionalidade,
        @NotNull Long codEscolaridade,
        LocalDateTime dtCadastro,
        @Pattern(regexp = "[AI]") String status
        ) {}
