package com.HelpDesk.services;

import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.repositories.TecnicoRepository;
import com.HelpDesk.services.exceptions.ObjectExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico finById(Long id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectExceptionHandler(id));
    }
}
