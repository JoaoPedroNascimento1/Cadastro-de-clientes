package br.com.cadastroclientes.service;

import br.com.cadastroclientes.entity.Cliente;
import br.com.cadastroclientes.exception.ResourceNotFoundException;
import br.com.cadastroclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  public Optional<Cliente> findById(Long id){
    if(clienteRepository.existsById(id)){
      return clienteRepository.findById(id);
    }
    throw new ResourceNotFoundException("Id não encontrado!");
  }

  public Cliente cadastrarCliente(Cliente cliente){
    return clienteRepository.save(cliente);
  }

  public void deletarCliente(Long id){
    if(clienteRepository.existsById(id)){
      clienteRepository.deleteById(id);;
    }
  }
}
