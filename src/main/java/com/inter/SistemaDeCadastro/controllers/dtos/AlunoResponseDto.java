package com.inter.SistemaDeCadastro.controllers.dtos;

import com.inter.SistemaDeCadastro.models.enums.NacionalidadeAlunoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record AlunoResponseDto(
        Integer codAluno,
        String nome,
        Date dataNasc,
        String sexo,
        String cpf,
        String rg,
        NacionalidadeAlunoEnum nacionalidade,
        Integer codEscolaridade,
        String status,
        Integer codUsuario

) {

}
