package com.gestaotamias.aplication.infrastructure.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class Relatorio {

    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String tipoRelatorio;
    private List<TotalPorTipo> totalPorTipo;
    private Double totalGeral;
}
