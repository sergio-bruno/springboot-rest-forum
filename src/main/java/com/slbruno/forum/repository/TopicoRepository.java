package com.slbruno.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slbruno.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
}
