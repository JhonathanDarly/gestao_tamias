package com.gestaotamias.aplication.controller;


import com.gestaotamias.aplication.controller.dtos.EntradaDTO;
import com.gestaotamias.aplication.infrastructure.entity.Entrada;
import com.gestaotamias.aplication.service.EntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/entrada")
@RequiredArgsConstructor
public class EntradaController {

    private final EntradaService entradaService;



    @PostMapping
    public ResponseEntity<EntradaDTO> salvarEntrada(@RequestBody EntradaDTO entradaDTO){
        EntradaDTO salvo = entradaService.salvarEntrada(entradaDTO);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> buscarTipoEntradaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(entradaService.buscarEntradaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrada(@PathVariable Long id) {
        entradaService.deletarEntrada(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
