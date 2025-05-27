package com.gestaotamias.aplication.controller;

import com.gestaotamias.aplication.controller.dtos.SaidaDTO;
import com.gestaotamias.aplication.infrastructure.entity.Saida;
import com.gestaotamias.aplication.service.SaidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/saida")
@RequiredArgsConstructor
public class SaidaController {

    private final SaidaService saidaService;

    @PostMapping
    public ResponseEntity<SaidaDTO> salvarSaida(@RequestBody SaidaDTO saidaDTO){
        SaidaDTO salvo = saidaService.salvarSaida(saidaDTO);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saida> buscarTipoSaidaPorId(@PathVariable Long id){
        return ResponseEntity.ok(saidaService.buscarSaidaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarsaida(@PathVariable Long id){
        saidaService.deletrarSaida(id);
        return ResponseEntity.noContent().build(); //HTTP 204 No Content
    }

}
