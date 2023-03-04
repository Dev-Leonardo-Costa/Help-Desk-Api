package com.HelpDesk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Propiedade {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private final Integer codigo;
    private final String descricao;

    public static Propiedade toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Propiedade x : Propiedade.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Prioridade inválido!");

    }
}
