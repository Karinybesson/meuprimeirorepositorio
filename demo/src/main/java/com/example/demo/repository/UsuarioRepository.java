package com.example.demo.repository;

import com.example.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<com.example.demo.model.Usuario,Long> {


    Usuario findByEmail(String email);
}
