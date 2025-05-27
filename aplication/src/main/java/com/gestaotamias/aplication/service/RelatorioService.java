package com.gestaotamias.aplication.service;

import com.gestaotamias.aplication.controller.dtos.RelatorioDTO;
import com.gestaotamias.aplication.controller.dtos.TotalPorTipoDTO;
import com.gestaotamias.aplication.infrastructure.repository.EntradaRepository;
import com.gestaotamias.aplication.infrastructure.repository.SaidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final EntradaRepository entradaRepository;
    private final SaidaRepository saidaRepository;

    public RelatorioDTO calcularTotalPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, String tipoRelatorio) {
        List<TotalPorTipoDTO> totais = new ArrayList<>();
        double totalGeral = 0.0;

        switch (tipoRelatorio.toUpperCase()) {
            case "ENTRADA":
                totais = entradaRepository.calcularTotaisPorTipo(dataInicial, dataFinal);
                totalGeral = totais.stream().mapToDouble(TotalPorTipoDTO::getValor).sum();
                break;
            case "SAIDA":
                totais = saidaRepository.calcularTotaisPorTipo(dataInicial, dataFinal);

                totalGeral = totais.stream().mapToDouble(TotalPorTipoDTO::getValor).sum();
                break;
            case "GERAL":
                TotalPorTipoDTO totalEntradas = entradaRepository.totalEntradaComTipo(dataInicial, dataFinal);
                TotalPorTipoDTO totalSaidas = saidaRepository.totalSaidaComTipo(dataInicial, dataFinal);

                totais.add(totalEntradas);
                totais.add(totalSaidas);

                totalGeral = (totalEntradas != null ? totalEntradas.getValor() : 0)
                        - (totalSaidas != null ? totalSaidas.getValor() : 0);


                break;

            default:
                throw new IllegalArgumentException("Tipo de relatório inválido.");
        }

        return new RelatorioDTO(dataInicial, dataFinal, tipoRelatorio, totais, totalGeral);
    }
}