package com.slbruno.forum.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.slbruno.forum.modelo.Topico;
import com.slbruno.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotEmpty @Length(min = 5)
	private String titulo;
	@NotEmpty @Length(min = 10)
	private String mensagem;
	
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
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}
	
}
