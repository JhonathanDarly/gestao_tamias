package com.gestaotamias.aplication.infrastructure.entity;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalPorTipo {
    private String tipo;
    private Double valor;
}
