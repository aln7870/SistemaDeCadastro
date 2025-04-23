package com.inter.SistemaDeCadastro.controllers.dtos.views;

import java.time.LocalDate;

public record ListaPresencaDto(
        Integer codAluno,
        String nomeAluno,
        String presenca,
        Integer codModalidade,
        Integer codTurno,
        LocalDate dataFalta,
        Integer codInscricaoModalidade
) {}

