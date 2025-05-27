package com.gestaotamias.aplication.service;

import com.gestaotamias.aplication.controller.dtos.EntradaDTO;
import com.gestaotamias.aplication.infrastructure.entity.Entrada;
import com.gestaotamias.aplication.infrastructure.entity.Membro;
import com.gestaotamias.aplication.infrastructure.entity.TipoEntrada;
import com.gestaotamias.aplication.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.aplication.infrastructure.repository.EntradaRepository;
import com.gestaotamias.aplication.infrastructure.repository.MembroRepository;
import com.gestaotamias.aplication.infrastructure.repository.TipoEntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntradaService {

    private final EntradaRepository entradaRepository;
    private final MembroRepository membroRepository;
    private final TipoEntradaRepository tipoEntradaRepository;

    public EntradaDTO salvarEntrada(EntradaDTO entradaDto) {
        try {
            Entrada entrada = new Entrada();

            // Buscar e associar Membro
            Membro membro = membroRepository.findById(entradaDto.getMembro_id())
                    .orElseThrow(() -> new RuntimeException("Membro não encontrado"));
            entrada.setMembro(membro);

            // Buscar e associar TipoEntrada
            TipoEntrada tipoEntrada = tipoEntradaRepository.findById(entradaDto.getTipoEntrada_id())
                    .orElseThrow(() -> new RuntimeException("Tipo de Entrada não encontrado"));
            entrada.setTipoEntrada(tipoEntrada);

            entrada.setDataLancamento(entradaDto.getDataLancamento());

            entrada.setValor(entradaDto.getValor());

            Entrada entradaSalva = entradaRepository.save(entrada);

            // Preencher DTO de retorno, se precisar
            EntradaDTO dtoResposta = new EntradaDTO();
            dtoResposta.setDataLancamento(entradaDto.getDataLancamento());
            dtoResposta.setValor(entradaSalva.getValor());
            dtoResposta.setMembro_id(membro.getId());
            dtoResposta.setTipoEntrada_id(tipoEntrada.getId());

            return dtoResposta;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar entrada: " + e.getMessage(), e);
        }
    }

    public Entrada buscarEntradaPorId(Long id) {
        return entradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }

    public void deletarEntrada(Long id) {
        entradaRepository.deleteById(id);
    }
}
