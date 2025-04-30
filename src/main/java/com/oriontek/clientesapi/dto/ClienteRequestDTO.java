package com.oriontek.clientesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class ClienteRequestDTO {

    @NotBlank(message = "El nombre del cliente no puede estar en blanco.")
    @Size(max = 255, message = "Name must be between 2 and 255 characters")
    private String nombre;

    @NotEmpty(message = "Debe agregar al menos una direccion.")
    private List<DireccionRequestDTO> direcciones;

}
