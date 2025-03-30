package com.inter.SistemaDeCadastro.controllers.dtos;

public record LoginResponse(String token, Long expiresIn) {
}
