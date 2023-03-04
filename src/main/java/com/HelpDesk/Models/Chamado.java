package com.HelpDesk.Models;

import com.HelpDesk.enums.Prioridade;
import com.HelpDesk.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chamado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String titulo;
    private String observacao;
    private Prioridade prioridade;
    private Status status;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento = LocalDate.now();

    private Tecnico tecnico;
    private Cliente cliente;

}
