package es.santander.ascender.ejerc006.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.santander.ascender.ejerc006.model.Silla;
import es.santander.ascender.ejerc006.repository.SillaRepository;
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
public class SillaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SillaRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        Silla silla = new Silla(null, "Rojo", 1.2, 1L);
        repository.save(silla);
    }

    @Test
    public void testObtenerTodasLasSillas() throws Exception {
        mockMvc.perform(get("/api/silla"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCrearSilla() throws Exception {
        Silla silla = new Silla(null, "Azul", 1.0, 1L);
        mockMvc.perform(post("/api/silla")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(silla)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testActualizarSilla() throws Exception {
        Silla silla = repository.findAll().get(0);
        silla.setColor("Verde");
        mockMvc.perform(put("/api/silla")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(silla)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

   @Test
    public void testEliminarSilla() throws Exception {
        Silla silla = new Silla(null, "Silla para eliminar", 1.0, 1L);
        repository.save(silla);

        mockMvc.perform(delete("/api/silla/" + silla.getId()))
                .andDo(print())
                .andReturn();

        boolean exists = repository.existsById(silla.getId());
        assertFalse(exists);
    }
}