package com.oriontek.clientesapi.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ClienteRequestDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "Debe contener las direcciones")
    private List<DireccionDTO> direcciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DireccionDTO> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionDTO> direcciones) {
        this.direcciones = direcciones;
    }
}
