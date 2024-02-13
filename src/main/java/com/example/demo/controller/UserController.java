package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {


    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario getUsuarioById(@PathVariable String idUsuario) {
        return usuarioRepository.getUsuarioById(idUsuario);
    }

    @DeleteMapping("/{idUsuario}")
    public String deleteUsuarioById(@PathVariable String idUsuario) {
        return usuarioRepository.delete(idUsuario);
    }

    @PutMapping("/{idUsuario}")
    public String updateUsuario(@PathVariable String idUsuario, @RequestBody Usuario usuario){
        return usuarioRepository.update(idUsuario, usuario);
    }


}
