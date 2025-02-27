package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Silla;

@SpringBootTest
public class SillaRepositoryTest {

    @Autowired
    private SillaRepository repository;

    @Test
    public void testCreate() {
        Silla silla = new Silla();
        silla.setColor("Rojo");
        silla.setAltura(1.2);
        silla.setMesaId(1L);
        repository.save(silla);

        assertTrue(repository.findById(silla.getId()).isPresent());
    }

    @Test
    public void delete() {
        Silla silla = new Silla();
        silla.setColor("Azul");
        silla.setAltura(1.0);
        silla.setMesaId(1L);
        repository.save(silla);

        assertTrue(repository.existsById(silla.getId()));

        repository.deleteById(silla.getId());

        assertFalse(repository.existsById(silla.getId()));
    }

    @Test
    public void view() {
        Silla silla = new Silla();
        silla.setColor("Verde");
        silla.setAltura(1.1);
        silla.setMesaId(1L);
        repository.save(silla);

        Optional<Silla> registro = repository.findById(silla.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getColor().equals("Verde"));
    }

    @Test
    public void update() {
        Silla silla = new Silla();
        silla.setColor("Amarillo");
        silla.setAltura(1.3);
        silla.setMesaId(1L);
        repository.save(silla);

        assertTrue(repository.existsById(silla.getId()));

        silla.setColor("Amarillo Actualizado");
        repository.save(silla);

        Optional<Silla> updatedSilla = repository.findById(silla.getId());

        assertTrue(updatedSilla.isPresent());
        assertTrue(updatedSilla.get().getColor().equals("Amarillo Actualizado"));
    }
}