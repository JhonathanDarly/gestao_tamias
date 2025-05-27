package com.gestaotamias.aplication.infrastructure.repository;

import com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO;
import com.gestaotamias.aplication.infrastructure.entity.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    Optional<Entrada> findById(Long id);

    @Query("SELECT new com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO(e.tipoEntrada.descricao, SUM(e.valor)) " +
            "FROM Entrada e WHERE e.dataLancamento BETWEEN :inicio AND :fim GROUP BY e.tipoEntrada.descricao")
    List<TotalPorTipoDTO> calcularTotaisPorTipo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

    @Query("SELECT new com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO('Entrada', SUM(e.valor)) " +
            "FROM Entrada e WHERE e.dataLancamento BETWEEN :inicio AND :fim")
    TotalPorTipoDTO totalEntradaComTipo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);


}