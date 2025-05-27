package com.gestaotamias.aplication.controller;

import com.gestaotamias.aplication.controller.dtos.MembroDto;
import com.gestaotamias.aplication.infrastructure.entity.Membro;
import com.gestaotamias.aplication.infrastructure.security.JwtUtil;
import com.gestaotamias.aplication.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membro")
@RequiredArgsConstructor
public class MembroController {

    private final MembroService membroService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Membro> salvarMembro(@RequestBody Membro membro) {
        Membro salvo = membroService.salvarMembro(membro);
        return ResponseEntity.ok(salvo);
    }


    @PostMapping("/login")
    public String login(@RequestBody MembroDto membroDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(membroDto.getLogin(), membroDto.getSenha())
        );


        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<Membro> buscarMembroPorNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(membroService.buscarMembroPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> buscarTipoEntradaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(membroService.buscarMembroPorId(id));
    }



    @DeleteMapping("/{login}")
    public ResponseEntity<Void> deletaMembroPorLogin(@PathVariable String login) {
        membroService.deletarMembroPorLogin(login);
        return ResponseEntity.ok().build();
    }
}
