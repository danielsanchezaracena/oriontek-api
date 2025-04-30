package com.oriontek.clientesapi.service;

import com.oriontek.clientesapi.dto.ClienteRequestDTO;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;
import com.oriontek.clientesapi.entity.Cliente;
import com.oriontek.clientesapi.entity.Direccion;
import com.oriontek.clientesapi.exception.ClienteNoEncontradoException;
import com.oriontek.clientesapi.repository.ClienteRepository;
import com.oriontek.clientesapi.utils.ClienteUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository repository;
    private final ClienteUtils clienteUtils;

    ClienteServiceImpl(ClienteRepository repository, ClienteUtils clienteUtils){
        this.repository = repository;
        this.clienteUtils=clienteUtils;
    }

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO request) {

        ClienteResponseDTO response=new ClienteResponseDTO();

        Cliente cliente=new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setActivo(true);
        cliente.setDirecciones(request.getDirecciones().stream().map(d->{
            Direccion direccion=new Direccion();
            direccion.setDireccion(d.getDireccion());
            direccion.setCliente(cliente);
            direccion.setActivo(true);
            return direccion;
        }).toList());

        Cliente nuevoCliente= repository.save(cliente);

        response.setId(nuevoCliente.getId());
        response.setNombre(cliente.getNombre());
        response.setDirecciones(clienteUtils.getDireccionesParaResponse(nuevoCliente));
        response.setActivo(cliente.isActivo());

        return response;
    }

    @Override
    public ClienteResponseDTO getCliente(Long id) {

        Optional<Cliente> optCliente= repository.findById(id);

        if(optCliente.isEmpty()){
            throw new ClienteNoEncontradoException("Cliente no encontrado con el id:"+id);
        }

        Cliente cliente=optCliente.get();

        ClienteResponseDTO response=new ClienteResponseDTO();
        response.setId(cliente.getId());
        response.setNombre(cliente.getNombre());
        response.setActivo(cliente.isActivo());
        response.setDirecciones(clienteUtils.getDireccionesParaResponse(cliente));

        return response;
    }

    @Override
    public List<ClienteResponseDTO> getAllClientes() {

        List<ClienteResponseDTO> clientes=new ArrayList<>();

        repository.findAll().forEach(c->{
            ClienteResponseDTO response=new ClienteResponseDTO();
            response.setId(c.getId());
            response.setNombre(c.getNombre());
            response.setActivo(c.isActivo());
            response.setDirecciones(clienteUtils.getDireccionesParaResponse(c));
            clientes.add(response);
        });

        return clientes;
    }

    @Override
    public void eliminarCliente(Long id) {

        Optional<Cliente> optCliente=repository.findById(id);

        if(optCliente.isEmpty()){
            throw new ClienteNoEncontradoException("Cliente no encontrado con el id:"+id);
        }

        repository.delete(optCliente.get());
    }

    @Override
    public ClienteResponseDTO modificarCliente(Long id, ClienteRequestDTO request) {

        Optional<Cliente> optCliente= repository.findById(id);

        if(optCliente.isEmpty()){
            throw new ClienteNoEncontradoException("Cliente no encontrado con el id:"+id);
        }

        Cliente cliente=optCliente.get();
        cliente.setNombre(request.getNombre());

        Cliente nuevoCliente = repository.save(cliente);

        ClienteResponseDTO response=new ClienteResponseDTO();
        response.setId(nuevoCliente.getId());
        response.setNombre(nuevoCliente.getNombre());
        response.setActivo(nuevoCliente.isActivo());
        response.setDirecciones(clienteUtils.getDireccionesParaResponse(nuevoCliente));

        return response;
    }




}
