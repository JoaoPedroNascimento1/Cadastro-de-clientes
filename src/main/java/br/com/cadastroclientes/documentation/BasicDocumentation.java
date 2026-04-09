package br.com.cadastroclientes.documentation;

import br.com.cadastroclientes.response.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Basic", description = "Parte responsável pela visualização de dados de clientes")
public interface BasicDocumentation {

  @Operation(summary = "Listar clientes", description = "Lista todos os clientes.",
    security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponse(responseCode = "200", description = "Clientes listados com sucesso.",
    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))))
  public ResponseEntity<List<ClienteResponse>> listarClientes();

  @Operation(summary = "Encontrar cliente", description = "Procura o cliente através do ID passado pelo basic ou admin.",
    security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso.",
    content = @Content(schema = @Schema(implementation = ClienteResponse.class)))
  @ApiResponse(responseCode = "404", description = "Cliente não encontrado.", content = @Content())
  public ResponseEntity<ClienteResponse> buscarCliente(@PathVariable Long id);

}
