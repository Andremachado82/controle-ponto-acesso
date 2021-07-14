package com.dio.live.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movimentacao {
	
	@Embeddable
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class MovimentacaoId implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Long idMovimento;
		
		private Long idUsuario;
	}
	
	@EmbeddedId
	private MovimentacaoId id;
	
	private LocalDateTime dataEntrada;
	
	private LocalDateTime dataSaida;
	
	private BigDecimal periodo;
	
	private Ocorrencia ocorrencia;
	
	private Calendario calendario;
	
}
