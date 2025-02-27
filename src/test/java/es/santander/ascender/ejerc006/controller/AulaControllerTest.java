package es.santander.ascender.ejerc006.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.santander.ascender.ejerc006.model.Aula;
import es.santander.ascender.ejerc006.repository.AulaRepository;
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
public class AulaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AulaRepository repository;

    private Aula aula;

    @BeforeEach
    public void setup() throws Exception {
        aula = new Aula(null, "Aula Test", 30, "Teórica", 1L);
        repository.save(aula);
    }

    @Test
    public void testObtenerTodasLasAulas() throws Exception {
        mockMvc.perform(get("/api/aula"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCrearAula() throws Exception {
        Aula nuevaAula = new Aula(null, "Aula Nueva", 25, "Práctica", 1L);
        mockMvc.perform(post("/api/aula")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(nuevaAula)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testActualizarAula() throws Exception {
        aula.setNombre("Aula Actualizada");
        mockMvc.perform(put("/api/aula")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(aula)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testEliminarAula() throws Exception {
        
        Aula aulaParaEliminar = new Aula(null, "Aula para eliminar", 20, "Laboratorio", 1L);
        repository.save(aulaParaEliminar);

        
        mockMvc.perform(delete("/api/aula/" + aulaParaEliminar.getId()))
               
                .andDo(print())
                .andReturn();

        
        boolean exists = repository.existsById(aulaParaEliminar.getId());
        assertFalse(exists);
    }
}