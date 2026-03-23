package br.com.cadastroclientes.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginRequest( @NotBlank(message = "Email obrigatório") String email,
                            @NotBlank(message = "Senha obrigatório") String senha) {
}
