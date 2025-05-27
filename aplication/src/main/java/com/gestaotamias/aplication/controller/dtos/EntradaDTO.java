package com.gestaotamias.aplication.controller.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDTO {

    private LocalDate dataLancamento;
    private Long membro_id;
    private Long tipoEntrada_id;
    private double valor;
}
