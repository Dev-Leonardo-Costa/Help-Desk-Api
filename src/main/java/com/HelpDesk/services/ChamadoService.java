package com.HelpDesk.services;

import com.HelpDesk.models.Chamado;
import com.HelpDesk.models.Cliente;
import com.HelpDesk.models.Tecnico;
import com.HelpDesk.dtos.chamado.ChamadoDTO;
import com.HelpDesk.enums.Prioridade;
import com.HelpDesk.enums.Status;
import com.HelpDesk.exceptions.ObjectExceptionHandler;
import com.HelpDesk.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado seekOrFail(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectExceptionHandler(id));
    }

    public List<Chamado> listAll() {
        return repository.findAll();
    }

    public Chamado create(Chamado obj) {
        return repository.save(obj);
    }

    public Chamado update(Long id, ChamadoDTO objDTO) {
        objDTO.setId(id);
        Chamado oldObj = seekOrFail(id);
        oldObj = newChamado(objDTO);
        return repository.save(oldObj);
    }

    private Chamado newChamado(ChamadoDTO obj) {
        Tecnico tecnico = tecnicoService.seekOrFail(obj.getTecnico());
        Cliente cliente = clienteService.seekOrFail(obj.getCliente());

        Chamado chamado = new Chamado();
        if(obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacao(obj.getObservacao());
        return chamado;
    }
}
