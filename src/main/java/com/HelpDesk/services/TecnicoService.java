package com.HelpDesk.services;

import com.HelpDesk.Models.Pessoa;
import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.dtos.tecnico.TecnicoDTO;
import com.HelpDesk.exceptions.DataIntegrityViolationException;
import com.HelpDesk.exceptions.ObjectExceptionHandler;
import com.HelpDesk.repositories.PessoaRepository;
import com.HelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Tecnico> listAll() {
        return repository.findAll();
    }

    public Tecnico saveObj(TecnicoDTO obj) {
        obj.setId(null);
        validaCpfEEmail(obj);
        Tecnico newObj = new Tecnico(obj);
        return repository.save(newObj);
    }

    public Tecnico update(Long id, TecnicoDTO objDTO) {
        objDTO.setId(id);
        Tecnico oldObj = seekOrFail(id);
        validaCpfEEmail(objDTO);
        oldObj = new Tecnico(objDTO);
        return repository.save(oldObj);
    }
    private void validaCpfEEmail(TecnicoDTO object) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(object.getCpf());
        if (obj.isPresent() && obj.get().getId() != object.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(object.getEmail());
        if (obj.isPresent() && obj.get().getId() != object.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }

    public Tecnico seekOrFail(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectExceptionHandler(id));
    }
}
