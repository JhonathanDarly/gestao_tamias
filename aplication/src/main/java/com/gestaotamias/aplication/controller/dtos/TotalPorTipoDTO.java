package com.gestaotamias.aplication.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TotalPorTipoDTO {

    private String tipo;
    private Double valor;

    public TotalPorTipoDTO(String tipo, Double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

}
