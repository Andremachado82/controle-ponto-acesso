package com.dio.live.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.exceptions.ObjectNotFoundException;
import com.dio.live.models.JornadaTrabalho;
import com.dio.live.repositories.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {
	
	@Autowired
	private JornadaTrabalhoRepository jornadaTrabalhoRepository;
	
	public JornadaTrabalho salvar(JornadaTrabalho jornadaTrabalho) {
		
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}
	
	public List<JornadaTrabalho> buscarLista() {
		
		List<JornadaTrabalho> jornada = jornadaTrabalhoRepository.findAll();
		 
		 return jornada;
	}
	
	public JornadaTrabalho buscarPorId(Long id)  throws ObjectNotFoundException {
		
		Optional<JornadaTrabalho> jornada = jornadaTrabalhoRepository.findById(id);
		 
		 return jornada.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + JornadaTrabalho.class.getName()));
	}
	
	public JornadaTrabalho atualizar(Long id, JornadaTrabalho jornada) {
		JornadaTrabalho jornadaTrabalho =  buscarJornadaPeloCodigo(id);
		
		BeanUtils.copyProperties(jornada, jornadaTrabalho, "id");
		
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}
	
	public JornadaTrabalho buscarJornadaPeloCodigo(Long id) {
		JornadaTrabalho jornadaTrabalho = jornadaTrabalhoRepository.findById(id)
			      .orElseThrow(() -> new ObjectNotFoundException(
			    		  "Objeto não encontrado! Id: " + id + ", Tipo: " + JornadaTrabalho.class.getName()));
		return jornadaTrabalho;
	}
	
}
