package com.HelpDesk.dtos.chamado;

import com.HelpDesk.models.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ChamadoDTO {

    private Long id;
    @NotBlank(message = "O campo TITULO é requerido!")
    private String titulo;
    @NotBlank(message = "O campo OBSERVAÇÂO é requerido!")
    private String observacao;
    @NotBlank(message = "O campo PRIORIDADE é requerido!")
    private Integer prioridade;

    @NotBlank(message = "O campo STATUS é requerido!")
    private Integer status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento = LocalDate.now();

    @NotBlank(message = "O campo TECNICO é requerido!")
    private Long tecnico;

    @NotBlank(message = "O campo CLIENTE é requerido!")
    private Long cliente;
    private String nomeTecnico;
    private String nomeCliente;

    public ChamadoDTO(Chamado obj) {
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade().getCodigo();
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacao = obj.getObservacao();
        this.tecnico = obj.getTecnico().getId();
        this.cliente = obj.getCliente().getId();
        this.nomeCliente = obj.getCliente().getNome();
        this.nomeTecnico = obj.getTecnico().getNome();
    }
}
