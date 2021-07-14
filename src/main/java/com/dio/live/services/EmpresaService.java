package com.dio.live.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.exceptions.ObjectNotFoundException;
import com.dio.live.models.Empresa;
import com.dio.live.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa salvar(Empresa empresa) {

		return empresaRepository.save(empresa);
	}

	public List<Empresa> buscarLista() {

		List<Empresa> jornada = empresaRepository.findAll();

		return jornada;
	}

	public Empresa buscarPorId(Long id) throws ObjectNotFoundException {

		Optional<Empresa> empresa = empresaRepository.findById(id);

		return empresa.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Empresa.class.getName()));
	}

	public Empresa atualizar(Long id, Empresa empresa) {
		Empresa empresaExistente = buscarEmpresaPorCodigo(id);

		BeanUtils.copyProperties(empresa, empresaExistente, "id");

		return empresaRepository.save(empresa);
	}

	public Empresa buscarEmpresaPorCodigo(Long id) {
		Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Empresa.class.getName()));
		return empresa;
	}

}
