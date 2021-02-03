package com.slbruno.forum.controller.docs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.slbruno.forum.controller.dto.DetalhesDoTopicoDto;
import com.slbruno.forum.controller.dto.TopicoDto;
import com.slbruno.forum.controller.form.AtualizacaoTopicoForm;
import com.slbruno.forum.controller.form.TopicoForm;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface TopicosControllerDocs {

    @ApiOperation(value = "Todos os itens do fórum listados")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acesso negado"),
            @ApiResponse(code = 404, message = "Não encontrado"),

    		@ApiResponse(code = 200, message = "Todos os itens do fórum encontrados na lista")
    })
	Page<TopicoDto> lista(Pageable paginacao);

    @ApiOperation(value = "Localizar um item do fórum por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acesso negado"),
            @ApiResponse(code = 404, message = "Não encontrado"),

            @ApiResponse(code = 200, message = "Item do fórum localizado com sucesso ")
    })
	Page<TopicoDto> listaPorNome(String nomeCurso, Pageable paginacao);
	
    @ApiOperation(value = "Cadastra um item no fórum")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acesso negado"),
            @ApiResponse(code = 404, message = "Não encontrado"),

            @ApiResponse(code = 201, message = "Item criado com sucesso no fórum"),
            @ApiResponse(code = 400, message = "Campos obrigatórios ausentes, valor de intervalo de campo incorreto ou item já registrado no sistema")
    })
    ResponseEntity<TopicoDto> cadastrar(TopicoForm form, UriComponentsBuilder uriBuilder);
	
    @ApiOperation(value = "Localizar um item do fórum por id")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acesso negado"),
            @ApiResponse(code = 404, message = "Item não encontrado no fórum pelo id"),
            @ApiResponse(code = 200, message = "Item do fórum localizado por id com sucesso ")
    })
	ResponseEntity<DetalhesDoTopicoDto> detalhar(Long id);
	
    @ApiOperation(value = "Atualizar item do fórum")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acesso negado"),
            @ApiResponse(code = 404, message = "Não encontrado"),

            @ApiResponse(code = 200, message = "item atualizado com sucesso por id"),
            @ApiResponse(code = 400, message = "Campos obrigatórios ausentes, valor de intervalo de campo incorreto ou item já registrado no sistema")
    })
	ResponseEntity<TopicoDto> atualizar(Long id, AtualizacaoTopicoForm form);
	
    @ApiOperation(value = "Deletar um item do fórum")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Acesso negado"),
            @ApiResponse(code = 404, message = "item do fórum não encontrado"),

            @ApiResponse(code = 204, message = "Item do fórum deletado com sucesso por id")
    })
	ResponseEntity<?> remover(Long id);

}
