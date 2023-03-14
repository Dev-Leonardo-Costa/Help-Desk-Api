package com.HelpDesk.config.modelmapper.assembler;

import com.HelpDesk.dtos.tecnico.TecnicoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TecnicoDTODissembler {

    @Autowired
    private ModelMapper modelMapper;

    public TecnicoDTO toDomainObj(TecnicoDTO objTDO){
        return modelMapper.map(objTDO, TecnicoDTO.class);
    }
}
