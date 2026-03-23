package br.com.cadastroclientes.response;

import br.com.cadastroclientes.enums.UserRole;
import lombok.Builder;

@Builder
public record UserResponse(Long id, String nome, String email, UserRole role) {
}
