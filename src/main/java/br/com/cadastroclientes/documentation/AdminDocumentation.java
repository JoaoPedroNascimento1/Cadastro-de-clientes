package br.com.cadastroclientes.documentation;

import br.com.cadastroclientes.request.ClienteRequest;
import br.com.cadastroclientes.response.ClienteResponse;
import br.com.cadastroclientes.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Admin", description = "Parte responsável pelo gerenciamento de cadastro e deleção de clientes")
public interface AdminDocumentation {

  @Operation(summary = "Criar cliente", description = "Cria cliente através de informações passadas pelo admin.",
    security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.",
    content = @Content(schema = @Schema(implementation = UserResponse.class)))
  @ApiResponse(responseCode = "400", description = "Informações passadas inválidas.", content = @Content())
  public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody ClienteRequest clienteRequest);

  @Operation(summary = "Deletar cliente", description = "Deleta cliente pelo ID.",
    security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso.", content = @Content())
  @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = @Content())
  public ResponseEntity<Void> deletarCliente(@PathVariable Long id);



}
