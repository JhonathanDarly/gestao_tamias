package com.gestaotamias.aplication.controller;



import com.gestaotamias.aplication.infrastructure.entity.TipoEntrada;
import com.gestaotamias.aplication.infrastructure.security.JwtUtil;
import com.gestaotamias.aplication.service.TipoEntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/tipoEntrada")
@RequiredArgsConstructor
public class TIpoEntradaController {

    private final TipoEntradaService tipoEntradaService;

    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<TipoEntrada> salvarTipoEntrada(@RequestBody TipoEntrada tipoEntrada) {
        TipoEntrada salvo = tipoEntradaService.salvarTipoEntrada(tipoEntrada);
        return ResponseEntity.ok(salvo);
    }


    @GetMapping
    public ResponseEntity<TipoEntrada> buscarTipoEntradaPorNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(tipoEntradaService.buscarTipoEntradaPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEntrada> buscarTipoEntradaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoEntradaService.buscarTipoEntradaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaTipoEntradaPorId(@PathVariable Long id) {
        tipoEntradaService.deletarTipoEntradaPorId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletaTipoEntradaPorNome(@PathVariable String nome) {
        tipoEntradaService.deletarTipoEntradaPorNome(nome);
        return ResponseEntity.ok().build();
    }
}

