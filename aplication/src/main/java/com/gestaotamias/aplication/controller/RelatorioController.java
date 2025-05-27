package com.gestaotamias.aplication.controller;

import com.gestaotamias.aplication.controller.dtos.RelatorioDTO;
import com.gestaotamias.aplication.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/relatorio")
@RequiredArgsConstructor
public class RelatorioController {

    private final RelatorioService relatorioService;

    @GetMapping
    public ResponseEntity<RelatorioDTO> relatorioPorData(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal,
            @RequestParam("tipo") String tipoRelatorio
    ) {
        RelatorioDTO relatorio = relatorioService.calcularTotalPorPeriodo(dataInicial, dataFinal, tipoRelatorio);
        return ResponseEntity.ok(relatorio);
    }
}