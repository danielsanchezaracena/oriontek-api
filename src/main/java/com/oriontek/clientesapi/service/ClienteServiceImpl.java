package com.oriontek.clientesapi.service;

import com.oriontek.clientesapi.dto.ClienteRequestDTO;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;
import com.oriontek.clientesapi.entity.Cliente;
import com.oriontek.clientesapi.entity.Direccion;
import com.oriontek.clientesapi.repository.ClienteRepository;
import com.oriontek.clientesapi.utils.ClienteUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    private ClienteRepository clienteRepository;
    private ClienteUtils clienteUtils;

    ClienteServiceImpl(ClienteRepository clienteRepository,ClienteUtils clienteUtils){
        this.clienteRepository=clienteRepository;
        this.clienteUtils=clienteUtils;
    }

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO cRequest) {

        ClienteResponseDTO cResponseDto=new ClienteResponseDTO();

        Cliente cliente=new Cliente();
        cliente.setNombre(cRequest.getNombre());
        cliente.setActivo(true);
        cliente.setDirecciones(cRequest.getDirecciones().stream().map(d->{
            Direccion direccion=new Direccion();
            direccion.setDireccion(d.getDireccion());
            direccion.setCliente(cliente);
            direccion.setActivo(true);
            return direccion;
        }).toList());

        Cliente nuevoCliente= clienteRepository.save(cliente);

        cResponseDto.setNombre(cliente.getNombre());
        cResponseDto.setDirecciones(clienteUtils.getDireccionesParaResponse(nuevoCliente));
        cResponseDto.setActivo(cliente.isActivo());

        return cResponseDto;
    }

    @Override
    public ClienteResponseDTO getCliente(Long id) {

        ClienteResponseDTO clienteResponseDTO=new ClienteResponseDTO();

        Optional<Cliente> optCliente=clienteRepository.findById(id);

        Cliente cliente=null;

        if(optCliente.isPresent()){
            cliente=optCliente.get();
        }

        if(cliente==null){
            throw new RuntimeException("Employee not found");
        }

        clienteResponseDTO.setNombre(cliente.getNombre());
        clienteResponseDTO.setActivo(cliente.isActivo());
        clienteResponseDTO.setDirecciones(clienteUtils.getDireccionesParaResponse(cliente));

        return clienteResponseDTO;
    }

    @Override
    public List<ClienteResponseDTO> getAllClientes() {

        List<ClienteResponseDTO> clientes=new ArrayList<>();

        clienteRepository.findAll().stream().forEach(c->{
            ClienteResponseDTO cResponseDTO=new ClienteResponseDTO();
            cResponseDTO.setNombre(c.getNombre());
            cResponseDTO.setActivo(c.isActivo());
            cResponseDTO.setDirecciones(clienteUtils.getDireccionesParaResponse(c));
            clientes.add(cResponseDTO);
        });

        return clientes;
    }


}
