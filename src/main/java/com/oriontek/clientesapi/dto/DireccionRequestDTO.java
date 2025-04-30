package com.oriontek.clientesapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DireccionRequestDTO {

    @NotBlank(message = "La direccion no puede estar en blanco")
    private String direccion;

}
