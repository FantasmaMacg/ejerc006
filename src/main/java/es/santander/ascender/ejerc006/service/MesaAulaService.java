package es.santander.ascender.ejerc006.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.MesaAula;
import es.santander.ascender.ejerc006.repository.MesaAulaRepository;

@Service
@Transactional
public class MesaAulaService {

    @Autowired
    private MesaAulaRepository repository;

    public MesaAula create(MesaAula mesaAula) {
        if (mesaAula.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro mesa utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 mesaAula.getId());
        }
        return repository.save(mesaAula);
    }

    @Transactional(readOnly = true)
    public MesaAula read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<MesaAula> read() {
        return repository.findAll();
    }

    public MesaAula update(MesaAula mesaAula) {
        if (mesaAula.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro mesa utilizando la modificación",
                                                 CRUDOperation.UPDATE, 
                                                 null);
        }
        return repository.save(mesaAula);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}