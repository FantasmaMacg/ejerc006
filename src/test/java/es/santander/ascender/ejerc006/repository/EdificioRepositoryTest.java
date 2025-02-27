package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Edificio;

@SpringBootTest
public class EdificioRepositoryTest {

    @Autowired
    private EdificioRepository repository;

    @Test
    public void testCreate() {
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio A");
        edificio.setUbicacion("Ubicación A");
        edificio.setDescripcion("Descripción A");
        repository.save(edificio);

        assertTrue(repository.findById(edificio.getId()).isPresent());
    }

    @Test
    public void delete() {
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio B");
        edificio.setUbicacion("Ubicación B");
        edificio.setDescripcion("Descripción B");
        repository.save(edificio);

        assertTrue(repository.existsById(edificio.getId()));

        repository.deleteById(edificio.getId());

        assertFalse(repository.existsById(edificio.getId()));
    }

    @Test
    public void view() {
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio C");
        edificio.setUbicacion("Ubicación C");
        edificio.setDescripcion("Descripción C");
        repository.save(edificio);

        Optional<Edificio> registro = repository.findById(edificio.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals("Edificio C"));
    }

    @Test
    public void update() {
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio D");
        edificio.setUbicacion("Ubicación D");
        edificio.setDescripcion("Descripción D");
        repository.save(edificio);

        assertTrue(repository.existsById(edificio.getId()));

        edificio.setNombre("Edificio D Actualizado");
        repository.save(edificio);

        Optional<Edificio> updatedEdificio = repository.findById(edificio.getId());

        assertTrue(updatedEdificio.isPresent());
        assertTrue(updatedEdificio.get().getNombre().equals("Edificio D Actualizado"));
    }
}