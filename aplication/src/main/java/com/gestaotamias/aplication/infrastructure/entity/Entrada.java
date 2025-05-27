package com.gestaotamias.aplication.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "entrada")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_lancamento", length = 20)
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @ManyToOne
    @JoinColumn(name = "tipoEntrada_id")
    private  TipoEntrada tipoEntrada;

    @Column(name = "valor")
    private double valor;


}
