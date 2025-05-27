package com.gestaotamias.aplication.infrastructure.repository;



import com.gestaotamias.aplication.infrastructure.entity.TipoEntrada;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoEntradaRepository extends JpaRepository<TipoEntrada, Long> {

    boolean existsByDescricao(String descricao);

    boolean existsById(Long id);

    Optional<TipoEntrada> findByDescricao(String descricao);

    Optional<TipoEntrada> findById(Long id);

    @Transactional
    void deleteByDescricao(String descricao);
}
