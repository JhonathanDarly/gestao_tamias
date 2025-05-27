package com.gestaotamias.aplication.infrastructure.repository;

import com.gestaotamias.aplication.infrastructure.entity.TipoSaida;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoSaidaRepository extends JpaRepository <TipoSaida, Long> {

    boolean existsByDescricao(String descricao);

    Optional<TipoSaida> findByDescricao(String descricao);

    Optional<TipoSaida> findById(Long id);

    @Transactional
    void deleteByDescricao(String descricao);
}
