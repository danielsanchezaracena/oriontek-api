package com.oriontek.clientesapi.exception;

import lombok.Data;

@Data
public class ClienteExceptionResponse {

    private int status;
    private String message;
    private long timestamp;
}
