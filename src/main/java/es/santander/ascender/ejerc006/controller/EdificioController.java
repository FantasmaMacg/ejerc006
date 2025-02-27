package es.santander.ascender.ejerc006.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.santander.ascender.ejerc006.model.Edificio;
import es.santander.ascender.ejerc006.service.EdificioService;

@RestController
@RequestMapping("/api/edificio")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    @PostMapping
    public Edificio create(@RequestBody Edificio edificio) {
        return edificioService.create(edificio);
    }

    @GetMapping("/{id}")
    public Edificio read(@PathVariable("id") Long id) {
        return edificioService.read(id);
    }

    @GetMapping
    public List<Edificio> list() {
        return edificioService.read();
    }

    @PutMapping
    public Edificio update(@RequestBody Edificio edificio) {
        return edificioService.update(edificio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        edificioService.delete(id);
    }
}