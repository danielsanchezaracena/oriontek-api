package com.oriontek.clientesapi.dto;

import java.util.List;

public class ClienteResponseDTO {

    private Long id;
    private String nombre;
    private boolean activo;
    private List<DireccionResponseDTO> direcciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DireccionResponseDTO> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionResponseDTO> direcciones) {
        this.direcciones = direcciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
