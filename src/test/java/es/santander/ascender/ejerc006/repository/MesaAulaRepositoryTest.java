package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.MesaAula;

@SpringBootTest
public class MesaAulaRepositoryTest {

    @Autowired
    private MesaAulaRepository repository;

    @Test
    public void testCreate() {
        MesaAula mesaAula = new MesaAula();
        mesaAula.setMaterial("Madera");
        mesaAula.setTamaño("Grande");
        mesaAula.setAulaId(1L);
        repository.save(mesaAula);

        assertTrue(repository.findById(mesaAula.getId()).isPresent());
    }

    @Test
    public void delete() {
        MesaAula mesaAula = new MesaAula();
        mesaAula.setMaterial("Metal");
        mesaAula.setTamaño("Mediana");
        mesaAula.setAulaId(1L);
        repository.save(mesaAula);

        assertTrue(repository.existsById(mesaAula.getId()));

        repository.deleteById(mesaAula.getId());

        assertFalse(repository.existsById(mesaAula.getId()));
    }

    @Test
    public void view() {
        MesaAula mesaAula = new MesaAula();
        mesaAula.setMaterial("Plástico");
        mesaAula.setTamaño("Pequeña");
        mesaAula.setAulaId(1L);
        repository.save(mesaAula);

        Optional<MesaAula> registro = repository.findById(mesaAula.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getMaterial().equals("Plástico"));
    }

    @Test
    public void update() {
        MesaAula mesaAula = new MesaAula();
        mesaAula.setMaterial("Vidrio");
        mesaAula.setTamaño("Grande");
        mesaAula.setAulaId(1L);
        repository.save(mesaAula);

        assertTrue(repository.existsById(mesaAula.getId()));

        mesaAula.setMaterial("Vidrio Templado");
        repository.save(mesaAula);

        Optional<MesaAula> updatedMesaAula = repository.findById(mesaAula.getId());

        assertTrue(updatedMesaAula.isPresent());
        assertTrue(updatedMesaAula.get().getMaterial().equals("Vidrio Templado"));
    }
}