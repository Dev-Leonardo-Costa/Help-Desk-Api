package com.HelpDesk.services;

import com.HelpDesk.Models.Chamado;
import com.HelpDesk.Models.Cliente;
import com.HelpDesk.exceptions.ObjectExceptionHandler;
import com.HelpDesk.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado seekOrFail(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectExceptionHandler(id));
    }

    public List<Chamado> listAll() {
        return repository.findAll();
    }
}
