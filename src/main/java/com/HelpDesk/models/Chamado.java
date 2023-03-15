package com.HelpDesk.models;

import com.HelpDesk.enums.Prioridade;
import com.HelpDesk.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String observacao;
    private Prioridade prioridade;

    @Column(nullable = false)
    private Status status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Chamado() {
    }

    public Chamado(Long id, String titulo, String observacao, Prioridade prioridade, Status status, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.titulo = titulo;
        this.observacao = observacao;
        this.prioridade = prioridade;
        this.status = status;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chamado chamado)) return false;
        return id.equals(chamado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
