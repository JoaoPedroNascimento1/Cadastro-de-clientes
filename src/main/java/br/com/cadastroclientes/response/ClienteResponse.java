package br.com.cadastroclientes.response;

import lombok.Builder;

@Builder
public record ClienteResponse(Long id, String nome, String email, String telefone) {
}
