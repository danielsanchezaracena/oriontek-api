package com.oriontek.clientesapi.service;

import com.oriontek.clientesapi.dto.ClienteRequestDTO;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {

 ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO);

 ClienteResponseDTO getCliente(Long id);

 List<ClienteResponseDTO> getAllClientes();





}
