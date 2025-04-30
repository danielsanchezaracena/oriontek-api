package com.oriontek.clientesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class ClienteRequestDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotEmpty(message = "Debe contener las direcciones")
    private List<DireccionRequestDTO> direcciones;

}
