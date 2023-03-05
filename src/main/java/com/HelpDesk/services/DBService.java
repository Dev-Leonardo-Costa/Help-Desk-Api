package com.HelpDesk.services;

import com.HelpDesk.Models.Chamado;
import com.HelpDesk.Models.Cliente;
import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.enums.Perfil;
import com.HelpDesk.enums.Prioridade;
import com.HelpDesk.enums.Status;
import com.HelpDesk.repositories.ChamadoRepository;
import com.HelpDesk.repositories.ClienteRepository;
import com.HelpDesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void povoaDB(){

        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Leonardo");
        tecnico.setCpf("7894561369");
        tecnico.setEmail("Leo@gmail.com");

        Cliente cliente = new Cliente();
        cliente.setNome("Chico zé");
        cliente.setCpf("4562187864");
        cliente.setEmail("chico@gmail.com");
        cliente.setPerfis(Perfil.CLIENTE);

        Chamado chamado = new Chamado();
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setStatus(Status.ANDAMENTO);
        chamado.setPrioridade(Prioridade.MEDIA);

        tecnicoRepository.saveAndFlush(tecnico);
        clienteRepository.saveAndFlush(cliente);
        chamadoRepository.saveAndFlush(chamado);
    }
}
