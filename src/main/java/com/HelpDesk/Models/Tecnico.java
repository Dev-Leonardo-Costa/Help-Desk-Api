package com.HelpDesk.Models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tecnico extends Pessoa {

    private List<Chamado> chamados = new ArrayList<>();

}
