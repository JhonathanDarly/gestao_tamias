package com.gestaotamias.aplication.infrastructure.repository;

import com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO;
import com.gestaotamias.aplication.infrastructure.entity.Saida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long> {

    Optional<Saida> findById(Long id);

    @Query("SELECT new com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO(s.tipoSaida.descricao, SUM(s.valor)) " +
            "FROM Saida s WHERE s.dataLancamento BETWEEN :inicio AND :fim GROUP BY s.tipoSaida.descricao")
    List<TotalPorTipoDTO> calcularTotaisPorTipo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

    @Query("SELECT new com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO('Saída', SUM(s.valor)) " +
            "FROM Saida s WHERE s.dataLancamento BETWEEN :inicio AND :fim")
    TotalPorTipoDTO totalSaidaComTipo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

}