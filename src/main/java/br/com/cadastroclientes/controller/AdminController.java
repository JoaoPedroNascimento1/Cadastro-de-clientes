package br.com.cadastroclientes.controller;

import br.com.cadastroclientes.documentation.AdminDocumentation;
import br.com.cadastroclientes.mapper.ClienteMapper;
import br.com.cadastroclientes.request.ClienteRequest;
import br.com.cadastroclientes.response.ClienteResponse;
import br.com.cadastroclientes.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController implements AdminDocumentation {

  private final ClienteService clienteService;

  @PostMapping
  public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody ClienteRequest clienteRequest){
    return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toClienteResponse(clienteService.cadastrarCliente(ClienteMapper.toCliente(clienteRequest))));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
    if (clienteService.findById(id).isPresent()) {
      clienteService.deletarCliente(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
