package com.oriontek.clientesapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DireccionRequestDTO {

    @NonNull
    @NotBlank(message = "La direccion no puede estar en blanco")
    private String direccion;

}
