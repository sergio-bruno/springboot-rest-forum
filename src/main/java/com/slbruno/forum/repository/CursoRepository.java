package com.slbruno.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slbruno.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
