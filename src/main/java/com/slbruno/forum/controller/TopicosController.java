package com.slbruno.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slbruno.forum.controller.dto.TopicoDto;
import com.slbruno.forum.modelo.Topico;
import com.slbruno.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository; 
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		//Topico topico = new Topico("Dúvida12", "Dúvida spring rest", new Curso("Soring", "Programação"));
		//return TopicoDto.converter(Arrays.asList(topico, topico, topico));
		List<Topico> topicos = topicoRepository.findAll();
		return TopicoDto.converter(topicos);
	}

	@RequestMapping("/topicos/prNome")
	public List<TopicoDto> listaPorNome(String nomeCurso) {
		List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
		return TopicoDto.converter(topicos);
	}
}
