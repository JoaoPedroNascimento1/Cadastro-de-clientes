package br.com.cadastroclientes.request;

import br.com.cadastroclientes.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record  UserRequest(@NotBlank(message = "Nome obrigatório") String nome,
                          @NotBlank(message = "Email obrigatório") @Email(message = "Email inválido") String email,
                          @NotBlank(message = "Senha obrigatório") String senha,
                          @NotNull(message = "Role obrigatório") UserRole role
) {
}
