package es.santander.ascender.ejerc006.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc006.model.Edificio;
import es.santander.ascender.ejerc006.repository.EdificioRepository;

@Service
@Transactional
public class EdificioService {

    @Autowired
    private EdificioRepository repository;

    public Edificio create(Edificio edificio) {
        if (edificio.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro edificio utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 edificio.getId());
        }
        return repository.save(edificio);
    }

    @Transactional(readOnly = true)
    public Edificio read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Edificio> read() {
        return repository.findAll();
    }

    public Edificio update(Edificio edificio) {
        if (edificio.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro edificio utilizando la modificación",
                                                 CRUDOperation.UPDATE, 
                                                 null);
        }
        return repository.save(edificio);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}