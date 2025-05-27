package com.gestaotamias.aplication.service;

import com.gestaotamias.aplication.infrastructure.entity.Membro;
import com.gestaotamias.aplication.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.aplication.infrastructure.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;
    private final PasswordEncoder passwordEncoder;

    public Membro salvarMembro(Membro membro){
        membro.setSenha(passwordEncoder.encode(membro.getSenha()));
        if (membroRepository.existsByLogin(membro.getLogin())){
            throw new IllegalArgumentException("Já existe um membro com este nome.");
        }

        return membroRepository.save(membro);
    }

    public Membro buscarMembroPorNome(String nome){
        return membroRepository.findByNome(nome).orElseThrow(() -> new ResourceNotFoundException("Nome não encontrado! " + nome));
    }

    public void deletarMembroPorLogin(String login){
        membroRepository.deleteByLogin(login);
    }

    public Membro buscarMembroPorId(Long id) {
        return membroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }
}
