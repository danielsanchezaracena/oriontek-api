package com.oriontek.clientesapi.service;

import com.oriontek.clientesapi.dto.ClienteRequestDTO;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;
import com.oriontek.clientesapi.dto.DireccionDTO;
import com.oriontek.clientesapi.entity.Cliente;
import com.oriontek.clientesapi.entity.Direccion;
import com.oriontek.clientesapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    private ClienteRepository clienteRepository;

    ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }


    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO cRequest) {

        ClienteResponseDTO cResponseDto=new ClienteResponseDTO();

        Cliente cliente=new Cliente();
        cliente.setNombre(cRequest.getNombre());
        cliente.setDirecciones(cRequest.getDirecciones().stream().map(d->{
            Direccion direccion=new Direccion();
            direccion.setDireccion(d.getDireccion());
            direccion.setCliente(cliente);
            return direccion;
        }).toList());
        Cliente nuevoCliente= clienteRepository.save(cliente);

        List<DireccionDTO> dirDTOList=nuevoCliente.getDirecciones().stream().map(d->{
            DireccionDTO dirDTO=new DireccionDTO();
            dirDTO.setDireccion(d.getDireccion());
            return dirDTO;
        }).toList();

        cResponseDto.setCliente(cliente);
        cResponseDto.setDirecciones(dirDTOList);

        return cResponseDto;
    }
}
