package com.HelpDesk.controllers;

import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.config.modelmapper.assembler.TecnicoDTOAssembler;
import com.HelpDesk.config.modelmapper.assembler.TecnicoDTODissembler;
import com.HelpDesk.dtos.tecnico.TecnicoDTO;
import com.HelpDesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @Autowired
    private TecnicoDTODissembler dissembler;

    @Autowired
    private TecnicoDTOAssembler assembler;

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> list = service.listAll();
        List<TecnicoDTO> listDTO = list.stream().map(TecnicoDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id) {
        Tecnico obj = service.seekOrFail(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
        Tecnico newObj = service.saveObj(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Long id, @Valid @RequestBody TecnicoDTO objDTO){
        Tecnico obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TecnicoDTO> delete(@PathVariable Long id){
        service.deleteObj(id);
        return ResponseEntity.noContent().build();
    }
}