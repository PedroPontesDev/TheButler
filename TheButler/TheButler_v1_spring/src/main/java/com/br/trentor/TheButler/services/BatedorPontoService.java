package com.br.trentor.TheButler.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.trentor.TheButler.model.dtos.BatedorPontoDTO;

public interface BatedorPontoService {

	BatedorPontoDTO baterPontoDeFuncionario(Long userId, LocalDateTime horarioEntada, LocalDateTime horariosaida) throws Exception;
	void registrarFaltaPorId(Long userId, LocalDate diaFalta, boolean teveFalta) throws Exception;
	void calcularHorasTrabalhadasDeFuncionarioMes(Long funcionarioId, Long batedorPontoId) throws Exception;
	
	
}
