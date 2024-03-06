package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path ="/usuario")
public abstract class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(
            @RequestParam String nome,
            @RequestParam String email
    ) {
        com.example.demo.model.Usuario usuario = new com.example.demo.model.Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuarioRepository.save(usuario);
        return "Salvou";
    }

    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<com.example.demo.model.Usuario> pegaTodos() {
        return usuarioRepository.findAll();
    }

    @RequestMapping(path = "/pegarporemail")
    public @ResponseBody Usuario pegarPorEmail(
            @RequestParam String email
    ){
        return usuarioRepository.findByEmail(email);
    }
}
