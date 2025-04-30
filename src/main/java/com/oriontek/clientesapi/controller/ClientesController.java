package com.oriontek.clientesapi.controller;

import com.oriontek.clientesapi.dto.ClienteRequestDTO;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;
import com.oriontek.clientesapi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientesController {

    private ClienteService clienteService;

    ClientesController(ClienteService clienteService){
        this.clienteService=clienteService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponseDTO> guardar(@RequestBody @Valid ClienteRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.crearCliente(request));
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAllClientes());
    }

    @GetMapping("/clientes/{idcliente}")
    public ResponseEntity<ClienteResponseDTO> getCliente(@PathVariable Long idcliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getCliente(idcliente));
    }






}
