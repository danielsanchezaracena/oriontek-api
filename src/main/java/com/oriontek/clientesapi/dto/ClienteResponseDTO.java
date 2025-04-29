package com.oriontek.clientesapi.dto;

import com.oriontek.clientesapi.entity.Cliente;

import java.util.List;

public class ClienteResponseDTO {

    private Cliente cliente;
    private boolean activo;
    private List<DireccionDTO> direcciones;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DireccionDTO> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionDTO> direcciones) {
        this.direcciones = direcciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
