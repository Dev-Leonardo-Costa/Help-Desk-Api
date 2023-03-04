package com.HelpDesk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private final Integer codigo;
    private final String descricao;

    public static Status toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Status x : Status.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido!");
        
    }
}
