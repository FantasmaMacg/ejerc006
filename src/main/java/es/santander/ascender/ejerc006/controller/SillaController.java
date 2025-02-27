package es.santander.ascender.ejerc006.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.santander.ascender.ejerc006.model.Silla;
import es.santander.ascender.ejerc006.service.SillaService;

@RestController
@RequestMapping("/api/silla")
public class SillaController {

    @Autowired
    private SillaService sillaService;

    @PostMapping
    public Silla create(@RequestBody Silla silla) {
        return sillaService.create(silla);
    }

    @GetMapping("/{id}")
    public Silla read(@PathVariable("id") Long id) {
        return sillaService.read(id);
    }

    @GetMapping
    public List<Silla> list() {
        return sillaService.read();
    }

    @PutMapping
    public Silla update(@RequestBody Silla silla) {
        return sillaService.update(silla);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        sillaService.delete(id);
    }
}