package com.HelpDesk.config.modelmapper.assembler;

import com.HelpDesk.Models.Tecnico;
import com.HelpDesk.dtos.tecnico.TecnicoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TecnicoDTOAssembler {

    @Autowired
    private ModelMapper mapper;

    public TecnicoDTO toModelDTO(Tecnico tecnico){
        return  mapper.map(tecnico, TecnicoDTO.class);
    }
    public List<TecnicoDTO> toCollectionModel(List<Tecnico> tecnicos){
        return tecnicos.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}
