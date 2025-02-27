package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Aula;

@SpringBootTest
public class AulaRepositoryTest {

    @Autowired
    private AulaRepository repository;

    @Test
    public void testCreate() {
        Aula aula = new Aula();
        aula.setNombre("Aula 1");
        aula.setCapacidad(30);
        aula.setTipo("Teórica");
        aula.setEdificioId(1L);
        repository.save(aula);

        assertTrue(repository.findById(aula.getId()).isPresent());
    }

    @Test
    public void delete() {
        Aula aula = new Aula();
        aula.setNombre("Aula 2");
        aula.setCapacidad(25);
        aula.setTipo("Práctica");
        aula.setEdificioId(1L);
        repository.save(aula);

        assertTrue(repository.existsById(aula.getId()));

        repository.deleteById(aula.getId());

        assertFalse(repository.existsById(aula.getId()));
    }

    @Test
    public void view() {
        Aula aula = new Aula();
        aula.setNombre("Aula 3");
        aula.setCapacidad(20);
        aula.setTipo("Laboratorio");
        aula.setEdificioId(1L);
        repository.save(aula);

        Optional<Aula> registro = repository.findById(aula.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals("Aula 3"));
    }

    @Test
    public void update() {
        Aula aula = new Aula();
        aula.setNombre("Aula 4");
        aula.setCapacidad(15);
        aula.setTipo("Teórica");
        aula.setEdificioId(1L);
        repository.save(aula);

        assertTrue(repository.existsById(aula.getId()));

        aula.setNombre("Aula 4 Actualizada");
        repository.save(aula);

        Optional<Aula> updatedAula = repository.findById(aula.getId());

        assertTrue(updatedAula.isPresent());
        assertTrue(updatedAula.get().getNombre().equals("Aula 4 Actualizada"));
    }
}