package br.com.cadastroclientes.response;

import lombok.Builder;

@Builder
public record LoginResponse(String token) {
}
