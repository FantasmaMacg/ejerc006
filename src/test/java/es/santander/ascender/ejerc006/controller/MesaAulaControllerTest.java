package es.santander.ascender.ejerc006.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.santander.ascender.ejerc006.model.MesaAula;
import es.santander.ascender.ejerc006.repository.MesaAulaRepository;
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
public class MesaAulaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MesaAulaRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        MesaAula mesaAula = new MesaAula(null, "Madera", "Grande", 1L);
        repository.save(mesaAula);
    }

    @Test
    public void testObtenerTodasLasMesas() throws Exception {
        mockMvc.perform(get("/api/mesa-aula"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCrearMesa() throws Exception {
        MesaAula mesaAula = new MesaAula(null, "Metal", "Mediana", 1L);
        mockMvc.perform(post("/api/mesa-aula")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mesaAula)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testActualizarMesa() throws Exception {
        MesaAula mesaAula = repository.findAll().get(0);
        mesaAula.setMaterial("Vidrio");
        mockMvc.perform(put("/api/mesa-aula")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mesaAula)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
  @Test
    public void testEliminarMesa() throws Exception {
        MesaAula mesaAula = new MesaAula(null, "Mesa para eliminar", "Mediana", 1L);
        repository.save(mesaAula);

        mockMvc.perform(delete("/api/mesa-aula/" + mesaAula.getId()))
                .andDo(print())
                .andReturn();

        boolean exists = repository.existsById(mesaAula.getId());
        assertFalse(exists);
    }
}