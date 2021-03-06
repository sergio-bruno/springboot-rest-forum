package com.slbruno.forum.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.slbruno.forum.modelo.Curso;
import com.slbruno.forum.modelo.Topico;
import com.slbruno.forum.repository.CursoRepository;

public class TopicoForm {

	@NotEmpty @Length(min = 5)
	private String titulo;
	@NotEmpty @Length(min = 10)
	private String mensagem;
	@NotEmpty 
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);	
		return new Topico(titulo, mensagem, curso);
	}
		
}
