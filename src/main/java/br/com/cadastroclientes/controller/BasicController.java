package br.com.cadastroclientes.controller;

import br.com.cadastroclientes.documentation.BasicDocumentation;
import br.com.cadastroclientes.mapper.ClienteMapper;
import br.com.cadastroclientes.response.ClienteResponse;
import br.com.cadastroclientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicController implements BasicDocumentation {

  private final ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<ClienteResponse>> listarClientes(){
    return ResponseEntity.ok(clienteService.findAll().stream().map(ClienteMapper::toClienteResponse).toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClienteResponse> buscarCliente(@PathVariable Long id){
    return clienteService.findById(id).map(cliente -> ResponseEntity.ok(ClienteMapper.toClienteResponse(cliente))).orElse(ResponseEntity.notFound().build());
  }
}
