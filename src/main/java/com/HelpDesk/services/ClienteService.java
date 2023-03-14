package com.HelpDesk.services;

import com.HelpDesk.Models.Cliente;
import com.HelpDesk.Models.Pessoa;
import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.dtos.tecnico.ClienteDTO;
import com.HelpDesk.dtos.tecnico.TecnicoDTO;
import com.HelpDesk.exceptions.DataIntegrityViolationException;
import com.HelpDesk.exceptions.ObjectExceptionHandler;
import com.HelpDesk.repositories.ClienteRepository;
import com.HelpDesk.repositories.PessoaRepository;
import com.HelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Cliente> listAll() {
        return repository.findAll();
    }

    public Cliente saveObj(ClienteDTO obj) {
        obj.setId(null);
        validaCpfEEmail(obj);
        Cliente newObj = new Cliente(obj);
        return repository.save(newObj);
    }

    public Cliente update(Long id, ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = seekOrFail(id);
        validaCpfEEmail(objDTO);
        oldObj = new Cliente(objDTO);
        return repository.save(oldObj);
    }
    public void deleteObj(Long id) {
        Cliente obj = seekOrFail(id);

        if (obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Tecnico possui ordens de serviço e não pode ser removido!");
        }

        repository.deleteById(id);
    }

    private void validaCpfEEmail(ClienteDTO object) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(object.getCpf());
        if (obj.isPresent() && obj.get().getId() != object.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(object.getEmail());
        if (obj.isPresent() && obj.get().getId() != object.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }

    public Cliente seekOrFail(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectExceptionHandler(id));
    }

    public List<Cliente> listAllObj(){
        return repository.findAll();
    }
}
