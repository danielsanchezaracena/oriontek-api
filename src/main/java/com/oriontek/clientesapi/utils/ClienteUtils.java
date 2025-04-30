package com.oriontek.clientesapi.utils;

import com.oriontek.clientesapi.dto.DireccionResponseDTO;
import com.oriontek.clientesapi.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteUtils {

    public List<DireccionResponseDTO> getDireccionesParaResponse(Cliente cliente){
        return cliente.getDirecciones().stream().map(d->{
            DireccionResponseDTO dDTO=new DireccionResponseDTO();
            dDTO.setDireccion(d.getDireccion());
            dDTO.setActivo(d.isActivo());
            dDTO.setId(d.getId());
            return dDTO;
        }).toList();
    }
}
