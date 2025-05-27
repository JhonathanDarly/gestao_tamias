package com.gestaotamias.aplication.service;

import com.gestaotamias.aplication.controller.dtos.SaidaDTO;
import com.gestaotamias.aplication.infrastructure.entity.Saida;
import com.gestaotamias.aplication.infrastructure.entity.TipoSaida;
import com.gestaotamias.aplication.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.aplication.infrastructure.repository.SaidaRepository;
import com.gestaotamias.aplication.infrastructure.repository.TipoSaidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaidaService {

    private final SaidaRepository saidaRepository;
    private final TipoSaidaRepository tipoSaidaRepository;

    public SaidaDTO salvarSaida(SaidaDTO saidaDTO) {
        Saida saida = new Saida();

            /* Converter data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
            Date data = sdf.parse(saidaDTO.getData_lancamento());
            saida.setDataLancamento(data);*/

        // Buscar e associar TipoSaida
        TipoSaida tipoSaida = tipoSaidaRepository.findById(saidaDTO.getTipoSaida_id())
                .orElseThrow(() -> new RuntimeException("Tipo de Saida não encontrado! "));
        saida.setTipoSaida(tipoSaida);

        saida.setDataLancamento(saidaDTO.getData_lancamento());

        saida.setValor(saidaDTO.getValor());

        Saida saidaSalva = saidaRepository.save(saida);

        // Preencher DTO de retorno, se precisar
        SaidaDTO dtoResposta = new SaidaDTO();
        dtoResposta.setData_lancamento(saidaDTO.getData_lancamento());
        dtoResposta.setTipoSaida_id(saidaDTO.getTipoSaida_id());
        dtoResposta.setValor(saidaDTO.getValor());

        return dtoResposta;

    }

    public Saida buscarSaidaPorId(Long id) {
        return saidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }

    public void deletrarSaida(Long id){
        saidaRepository.deleteById(id);
    }
}

