package com.gestaotamias.aplication.controller;

import com.gestaotamias.aplication.infrastructure.entity.TipoSaida;
import com.gestaotamias.aplication.service.TipoSaidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/tipoSaida")
@RequiredArgsConstructor
public class TipoSaidaController {

    private final TipoSaidaService tipoSaidaService;

    @PostMapping
    public ResponseEntity<TipoSaida> salvarTipoSaida(@RequestBody TipoSaida tipoSaida){
        TipoSaida salvo = tipoSaidaService.salvarTipoSaida(tipoSaida);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<TipoSaida> buscarTipoSaidaPorNome(@RequestParam("descricao") String descricao){
        return ResponseEntity.ok(tipoSaidaService.buscarTipoSaidaPorDescricao(descricao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoSaida> buscarTipoSaidaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoSaidaService.buscarTipoSaidaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaTipoSaidaPorId(@PathVariable Long id) {
        tipoSaidaService.deletarTipoSaidaPorId(id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletaTipoSaidaPorNome(@PathVariable String descricao) {
        tipoSaidaService.deletarTipoSaidaPorDescricao(descricao);
        return ResponseEntity.ok().build();
    }

}
