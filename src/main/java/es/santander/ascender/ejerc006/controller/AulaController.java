package es.santander.ascender.ejerc006.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.santander.ascender.ejerc006.model.Aula;
import es.santander.ascender.ejerc006.service.AulaService;

@RestController
@RequestMapping("/api/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping
    public Aula create(@RequestBody Aula aula) {
        return aulaService.create(aula);
    }

    @GetMapping("/{id}")
    public Aula read(@PathVariable("id") Long id) {
        return aulaService.read(id);
    }

    @GetMapping
    public List<Aula> list() {
        return aulaService.read();
    }

    @PutMapping
    public Aula update(@RequestBody Aula aula) {
        return aulaService.update(aula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        aulaService.delete(id);
    }
}