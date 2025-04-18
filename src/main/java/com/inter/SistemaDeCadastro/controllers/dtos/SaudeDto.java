package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SaudeDto(
        Long codSaude,

        @Size(max = 255) String descricaoAlergia,

        @Size(max = 255) String descricaoMedicacao,

        @Size(max = 255) String descricaoProblemaSaude,

        @Size(max = 255) String tipoDeficiencia,

        @Pattern(regexp = "[AI]") String status
) {}
