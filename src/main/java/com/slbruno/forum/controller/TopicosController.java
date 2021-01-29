package com.slbruno.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.slbruno.forum.controller.dto.TopicoDto;
import com.slbruno.forum.controller.form.TopicoForm;
import com.slbruno.forum.modelo.Topico;
import com.slbruno.forum.repository.CursoRepository;
import com.slbruno.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository; 
	
	@Autowired
	private CursoRepository cursoRepository; 

	@GetMapping
	public List<TopicoDto> lista() {
		//Topico topico = new Topico("Dúvida12", "Dúvida spring rest", new Curso("Soring", "Programação"));
		//return TopicoDto.converter(Arrays.asList(topico, topico, topico));
		List<Topico> topicos = topicoRepository.findAll();
		return TopicoDto.converter(topicos);
	}

	@GetMapping("/prnome")
	public List<TopicoDto> listaPorNome(String nomeCurso) {
		List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
		return TopicoDto.converter(topicos);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
}
