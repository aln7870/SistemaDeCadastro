package com.inter.SistemaDeCadastro.controllers.dtos.views;

public record AlunoPorModalidadeDto(
        Integer codAluno,
        String nomeAluno,
        Integer codModalidade,
        String statusAluno,
        String statusModalidade
) {}
