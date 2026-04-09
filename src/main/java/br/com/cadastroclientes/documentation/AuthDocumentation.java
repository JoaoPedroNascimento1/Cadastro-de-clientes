package br.com.cadastroclientes.documentation;

import br.com.cadastroclientes.request.LoginRequest;
import br.com.cadastroclientes.request.UserRequest;
import br.com.cadastroclientes.response.LoginResponse;
import br.com.cadastroclientes.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Parte responsável pelo gerenciamento de registro e login dos usuários")
public interface AuthDocumentation {

  @Operation(summary = "Registrar usuário", description = "Registra o usuário com informações passadas pelo usuário.")
  @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso.",
    content = @Content(schema = @Schema(implementation = UserResponse.class)))
  @ApiResponse(responseCode = "400", description = "Informações passadas inválidas.", content = @Content())
  public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest);

  @Operation(summary = "Login do usuário", description = "Faz o login do usuário através de email e senha.")
  @ApiResponse(responseCode = "201", description = "Usuário logado com sucesso.",
    content = @Content(schema = @Schema(implementation = LoginResponse.class)))
  @ApiResponse(responseCode = "400", description = "Informações passadas inválidas.", content = @Content())
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest);


}
