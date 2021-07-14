package com.dio.live.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.exceptions.ObjectNotFoundException;
import com.dio.live.models.JornadaTrabalho;
import com.dio.live.repositories.JornadaTrabalhoRepository;
import com.dio.live.services.JornadaTrabalhoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jornada")
@Api(value="API REST Jornada de Trabalho")
@CrossOrigin(origins = "*")
public class JornadaTrabalhoController {
	
	@Autowired
	JornadaTrabalhoService jornadaTrabalhoService;
	
	@Autowired
	private JornadaTrabalhoRepository jornadaTrabalhoRepository;
	
	@PostMapping
	public JornadaTrabalho salvarJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		JornadaTrabalho jornada = jornadaTrabalhoService.salvar(jornadaTrabalho);
		
		return jornada;
	}
	
	@GetMapping("/listar")
	@ApiOperation(value="Retorna uma lista de jornadas de trabalho")
	public List<JornadaTrabalho> buscarLista() {
		List<JornadaTrabalho> jornada = jornadaTrabalhoService.buscarLista();
		
		return jornada;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalho>buscarPorId(@PathVariable("id")Long id) throws ObjectNotFoundException {
		JornadaTrabalho jornada = jornadaTrabalhoService.buscarPorId(id);
		
		return ResponseEntity.ok().body(jornada);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<JornadaTrabalho>atualizar(@PathVariable Long id, @Validated @RequestBody JornadaTrabalho jornada) throws Exception {
		JornadaTrabalho jornadaTrabalho = jornadaTrabalhoService.atualizar(id, jornada);
		
		return ResponseEntity.ok(jornadaTrabalho);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id)  throws ObjectNotFoundException {
		jornadaTrabalhoService.buscarJornadaPeloCodigo(id);
		jornadaTrabalhoRepository.deleteById(id);
	}
	

}
