package com.example.Foro.repository;

import com.example.Foro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByEmail(String email);
}
