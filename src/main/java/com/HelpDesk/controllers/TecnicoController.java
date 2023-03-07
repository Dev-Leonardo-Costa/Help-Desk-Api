package com.HelpDesk.controllers;

import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.dtos.TecnicoDTO;
import com.HelpDesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id) {
        Tecnico obj = service.finById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

}