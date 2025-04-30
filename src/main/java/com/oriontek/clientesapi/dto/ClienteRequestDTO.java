package com.oriontek.clientesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class ClienteRequestDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotEmpty(message = "Debe contener las direcciones")
    private List<DireccionRequestDTO> direcciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DireccionRequestDTO> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionRequestDTO> direcciones) {
        this.direcciones = direcciones;
    }
}
