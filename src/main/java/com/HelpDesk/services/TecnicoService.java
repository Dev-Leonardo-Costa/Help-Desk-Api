package com.HelpDesk.services;

import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.dtos.tecnico.TecnicoDTO;
import com.HelpDesk.repositories.TecnicoRepository;
import com.HelpDesk.exceptions.ObjectExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public List<Tecnico> listAll() {
        return repository.findAll();
    }
    public Tecnico saveObj(TecnicoDTO obj) {
        obj.setId(null);
        Tecnico newObj = new Tecnico(obj);
        return repository.save(newObj);
    }

    public Tecnico seekOrFail (Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectExceptionHandler(id));
    }
}
