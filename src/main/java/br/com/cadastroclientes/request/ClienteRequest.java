package br.com.cadastroclientes.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ClienteRequest(@NotBlank(message = "Nome obrigatório")String nome,
                             @NotBlank(message = "Email obrigatório")String email,
                             @NotBlank(message = "Telefone obrigatório")String telefone) {
}
