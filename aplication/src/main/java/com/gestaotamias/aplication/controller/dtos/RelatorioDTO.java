package com.gestaotamias.aplication.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioDTO {


    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String tipoRelatorio;
    private List<TotalPorTipoDTO> totalPorTipo;
    private Double totalGeral;
}
