package br.com.cadastroclientes.mapper;

import br.com.cadastroclientes.entity.Cliente;
import br.com.cadastroclientes.request.ClienteRequest;
import br.com.cadastroclientes.response.ClienteResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClienteMapper {

  public Cliente toCliente(ClienteRequest clienteRequest){
    return Cliente.builder()
      .nome(clienteRequest.nome())
      .email(clienteRequest.email())
      .telefone(clienteRequest.telefone())
      .build();
  }

  public ClienteResponse toClienteResponse(Cliente cliente){
    return ClienteResponse.builder()
      .id(cliente.getId())
      .nome(cliente.getNome())
      .email(cliente.getEmail())
      .telefone(cliente.getTelefone())
      .build();
  }
}
