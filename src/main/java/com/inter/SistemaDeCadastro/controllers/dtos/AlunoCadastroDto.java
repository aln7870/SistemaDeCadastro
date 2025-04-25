package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoCadastroDto(
        @NotBlank String nomeAluno,
        @NotNull LocalDate dataNascimento,
        @NotBlank String sexo,
        @NotBlank String cpf,
        @NotBlank String rg,
        @NotBlank String nacionalidade,
        @NotNull Integer codEscolaridade,
        Integer codUsuario,

        // Endereço
        @NotBlank String cep,
        @NotBlank String rua,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotNull Integer numero,
        @NotBlank String resideCom,
        @NotBlank String outroResideCom,

        // Contato
        @NotBlank String responsavelEmergencial,
        @NotBlank String telefonePrincipal,
        @NotBlank String telefoneEmergencial,
        @NotBlank String email,

        // Saúde
        @NotBlank String descricaoAlergia,
        @NotBlank String descricaoMedicacao,
        @NotBlank String descricaoProblemaSaude,
        @NotBlank String tipoDeficienca,

        // Familiar
        @NotBlank String nomeFamiliar,
        @NotNull LocalDate dataNascimentoFamiliar,
        @NotBlank String parentesco,
        @NotNull Integer codEscolaridadeFamiliar,
        @NotNull Integer codOcupacaoFamiliar,

        // Inscrição
        @NotNull Integer codModalidade,
        @NotNull Integer codTurno
) {}
