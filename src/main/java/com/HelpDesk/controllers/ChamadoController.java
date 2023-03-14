package com.HelpDesk.controllers;

import com.HelpDesk.Models.Chamado;
import com.HelpDesk.dtos.chamado.ChamadoDTO;
import com.HelpDesk.services.ChamadoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Long id){
        Chamado obj = service.seekOrFail(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }
}
