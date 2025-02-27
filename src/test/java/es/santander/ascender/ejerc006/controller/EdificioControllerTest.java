package es.santander.ascender.ejerc006.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.santander.ascender.ejerc006.model.Edificio;
import es.santander.ascender.ejerc006.repository.EdificioRepository;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EdificioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EdificioRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        Edificio edificio = new Edificio(null, "Edificio Test", "Ubicación Test", "Descripción Test");
        repository.save(edificio);
    }

    @Test
    public void testObtenerTodosLosEdificios() throws Exception {
        mockMvc.perform(get("/api/edificio"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCrearEdificio() throws Exception {
        Edificio edificio = new Edificio(null, "Edificio Nuevo", "Ubicación Nueva", "Descripción Nueva");
        mockMvc.perform(post("/api/edificio")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(edificio)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testActualizarEdificio() throws Exception {
        Edificio edificio = repository.findAll().get(0);
        edificio.setNombre("Edificio Actualizado");
        mockMvc.perform(put("/api/edificio")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(edificio)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

     @Test
    public void testEliminarEdificio() throws Exception {
        Edificio edificio = new Edificio(null, "Edificio para eliminar", "Ubicación para eliminar", "Descripción para eliminar");
        repository.save(edificio);

        mockMvc.perform(delete("/api/edificio/" + edificio.getId()))
                .andDo(print())
                .andReturn();

        boolean exists = repository.existsById(edificio.getId());
        assertFalse(exists);
    }
}