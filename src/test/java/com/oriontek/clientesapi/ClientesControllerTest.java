package com.oriontek.clientesapi;

import com.oriontek.clientesapi.controller.ClientesController;
import com.oriontek.clientesapi.dto.ClienteResponseDTO;
import com.oriontek.clientesapi.exception.ClienteNoEncontradoException;
import com.oriontek.clientesapi.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ClientesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    private ClienteResponseDTO response;

    @BeforeEach
    void setUp(){
        response=new ClienteResponseDTO();
        response.setNombre("Cerveceria Nacional");
        response.setDirecciones(new ArrayList<>());
    }

    @Test
    void testGetClienteById() throws Exception {
        Mockito.when(clienteService.getCliente(1l)).thenReturn(response);

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Cerveceria Nacional"))
                .andExpect(jsonPath("$.direcciones").exists());
    }

    @Test
    void testClienteNoEncontrado() throws Exception{

        Long id=99l;
        Mockito.when(clienteService.getCliente(id))
                .thenThrow(new ClienteNoEncontradoException("Cliente no encontrado con el id:"+id));

        mockMvc.perform(get("/api/clientes/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Cliente no encontrado con el id:"+id));

    }

}
