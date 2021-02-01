package com.slbruno.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slbruno.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long >{

	Optional<Usuario> findByEmail(String email);
}
