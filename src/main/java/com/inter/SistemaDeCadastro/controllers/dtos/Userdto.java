package com.inter.SistemaDeCadastro.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public record Userdto(@NotBlank String nome,@NotBlank String senha, String role) {
}
