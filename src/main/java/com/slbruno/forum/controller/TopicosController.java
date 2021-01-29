package com.slbruno.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slbruno.forum.controller.dto.TopicoDto;
import com.slbruno.forum.modelo.Curso;
import com.slbruno.forum.modelo.Topico;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		Topico topico = new Topico("Dúvida12", "Dúvida spring rest", new Curso("Soring", "Programação"));
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
	}
}
