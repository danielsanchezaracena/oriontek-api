package com.oriontek.clientesapi.controller;

import com.oriontek.clientesapi.dto.ClienteRequestDTO;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;
import com.oriontek.clientesapi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientesController {

    private final ClienteService clienteService;

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

    @PutMapping("/clientes/{idcliente}")
    public ResponseEntity<ClienteResponseDTO> modificarCliente(@PathVariable Long idcliente,@RequestBody ClienteRequestDTO request){
       return ResponseEntity.status(HttpStatus.OK).body(clienteService.modificarCliente(idcliente,request));
    }


    @DeleteMapping("clientes/{idcliente}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long idcliente){
        clienteService.eliminarCliente(idcliente);
        return ResponseEntity.ok().build();
    }




}
