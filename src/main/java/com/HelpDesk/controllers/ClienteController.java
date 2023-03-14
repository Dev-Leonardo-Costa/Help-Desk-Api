package com.HelpDesk.controllers;

import com.HelpDesk.Models.Cliente;
import com.HelpDesk.dtos.cliente.ClienteDTO;
import com.HelpDesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = service.listAll();
        List<ClienteDTO> listDTO = list.stream().map(ClienteDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        Cliente obj = service.seekOrFail(id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO){
        Cliente newObj = service.saveObj(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO objDTO){
        Cliente obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id){
        service.deleteObj(id);
        return ResponseEntity.noContent().build();
    }
}