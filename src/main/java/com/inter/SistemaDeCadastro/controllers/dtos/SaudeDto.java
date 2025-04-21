package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SaudeDto(

       String descricaoAlergia,

       String descricaoMedicacao,

        String descricaoProblemaSaude,

        String tipoDeficiencia,

        String status,

        @NotNull Integer codAluno
) {}
