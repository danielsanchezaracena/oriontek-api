package com.oriontek.clientesapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String nombre;
    private boolean activo;
    private List<DireccionResponseDTO> direcciones;

}
