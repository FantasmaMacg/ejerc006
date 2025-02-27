package es.santander.ascender.ejerc006.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.santander.ascender.ejerc006.model.MesaAula;
import es.santander.ascender.ejerc006.service.MesaAulaService;

@RestController
@RequestMapping("/api/mesa-aula")
public class MesaAulaController {

    @Autowired
    private MesaAulaService mesaAulaService;

    @PostMapping
    public MesaAula create(@RequestBody MesaAula mesaAula) {
        return mesaAulaService.create(mesaAula);
    }

    @GetMapping("/{id}")
    public MesaAula read(@PathVariable("id") Long id) {
        return mesaAulaService.read(id);
    }

    @GetMapping
    public List<MesaAula> list() {
        return mesaAulaService.read();
    }

    @PutMapping
    public MesaAula update(@RequestBody MesaAula mesaAula) {
        return mesaAulaService.update(mesaAula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        mesaAulaService.delete(id);
    }
}