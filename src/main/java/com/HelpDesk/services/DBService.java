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

import java.util.List;

@Service
public class DBService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void povoaDB(){

        Tecnico tecnico = new Tecnico(null, "Leonardo", "186.614.790-02", "Leo@gmail.com", "456" );
        tecnico.addPerfil(Perfil.ADMIN);
        Cliente cliente = new Cliente(null,"Chico zé", "745.085.710-34","chico@gmail.com","123");
        Chamado chamado = new Chamado(null,"Landing Page","olhar o limete do prazo", Prioridade.MEDIA, Status.ANDAMENTO, tecnico, cliente);

        tecnicoRepository.saveAll(List.of(tecnico));
        clienteRepository.saveAll(List.of(cliente));
        chamadoRepository.saveAll(List.of(chamado));

    }
}
