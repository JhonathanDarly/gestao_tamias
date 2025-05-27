package com.gestaotamias.aplication.service;

import com.gestaotamias.aplication.infrastructure.entity.TipoSaida;
import com.gestaotamias.aplication.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.aplication.infrastructure.repository.TipoSaidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoSaidaService {

    private final TipoSaidaRepository tipoSaidaRepository;


    public TipoSaida salvarTipoSaida(TipoSaida tipoSaida){
        if(tipoSaidaRepository.existsByDescricao(tipoSaida.getDescricao())){
            throw new IllegalArgumentException("Já existe um TipoSaida com esta descrição!");
        }
        return tipoSaidaRepository.save(tipoSaida);
    }

    public TipoSaida buscarTipoSaidaPorDescricao(String descricao){
        return tipoSaidaRepository.findByDescricao(descricao).orElseThrow(() -> new ResourceNotFoundException("Nome não encontrado! " + descricao));
    }

    public void deletarTipoSaidaPorDescricao(String descricao){
        tipoSaidaRepository.deleteByDescricao(descricao);
    }

    public TipoSaida buscarTipoSaidaPorId(Long id){
        return tipoSaidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }

    public void deletarTipoSaidaPorId(Long id) {
        tipoSaidaRepository.deleteById(id);
    }
}
