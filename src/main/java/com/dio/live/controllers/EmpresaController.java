package com.dio.live.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.dio.live.models.Empresa;
import com.dio.live.repositories.EmpresaRepository;
import com.dio.live.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@Autowired
	EmpresaRepository empresaRepository;

	@PostMapping
	public ResponseEntity<Empresa> salvar(@RequestBody Empresa empresa) {

		return ResponseEntity.ok().body(empresaService.salvar(empresa));
	}

	@GetMapping("{id}")
	public ResponseEntity<Empresa> buscarLista(@PathVariable Long id) {

		return ResponseEntity.ok(empresaService.buscarPorId(id));
	}

	@GetMapping("/listar")
	public List<Empresa> buscarLista() {

		return empresaService.buscarLista();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @Validated @RequestBody Empresa jornada)
			throws Exception {

		return ResponseEntity.ok(empresaService.atualizar(id, jornada));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ObjectNotFoundException {
		empresaService.buscarEmpresaPorCodigo(id);
		empresaRepository.deleteById(id);
	}

}
