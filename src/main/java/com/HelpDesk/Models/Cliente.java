package com.HelpDesk.Models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends Pessoa {

    private List<Chamado> chamados = new ArrayList<>();

}
