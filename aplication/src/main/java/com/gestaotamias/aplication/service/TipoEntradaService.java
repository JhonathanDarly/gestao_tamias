package com.gestaotamias.aplication.service;


import com.gestaotamias.aplication.infrastructure.entity.TipoEntrada;
import com.gestaotamias.aplication.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.aplication.infrastructure.repository.TipoEntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoEntradaService {

    private final TipoEntradaRepository tipoEntradaRepository;
    private final PasswordEncoder passwordEncoder;

    public TipoEntrada salvarTipoEntrada(TipoEntrada tipoEntrada){
        if (tipoEntradaRepository.existsByDescricao(tipoEntrada.getDescricao())){
            throw new IllegalArgumentException("Já existe um TipoEntrada com este nome.");
        }

        return tipoEntradaRepository.save(tipoEntrada);
    }

    public TipoEntrada buscarTipoEntradaPorNome(String nome){
        return tipoEntradaRepository.findByDescricao(nome).orElseThrow(() -> new ResourceNotFoundException("Nome não encontrado! " + nome));
    }

    public void deletarTipoEntradaPorNome(String descricao){
        tipoEntradaRepository.deleteByDescricao(descricao);
    }

    public TipoEntrada buscarTipoEntradaPorId(Long id) {
        return tipoEntradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }

    public void deletarTipoEntradaPorId(Long id) {
        tipoEntradaRepository.deleteById(id);
    }
}
