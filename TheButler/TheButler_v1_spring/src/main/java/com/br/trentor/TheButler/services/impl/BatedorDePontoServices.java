package com.br.trentor.TheButler.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.trentor.TheButler.model.dtos.BatedorPontoDTO;
import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.model.entities.BatedorPonto;
import com.br.trentor.TheButler.model.entities.Cardapio;
import com.br.trentor.TheButler.model.entities.Garcom;
import com.br.trentor.TheButler.model.entities.Usuario;
import com.br.trentor.TheButler.model.mapper.MyMapper;
import com.br.trentor.TheButler.repositories.BatedorPontoRepositories;
import com.br.trentor.TheButler.repositories.CardapioRepositories;
import com.br.trentor.TheButler.repositories.GarcomRepositories;
import com.br.trentor.TheButler.repositories.UsuarioRepositories;
import com.br.trentor.TheButler.services.BatedorPontoService;
import com.br.trentor.TheButler.services.GarcomServices;

import jakarta.transaction.Transactional;

@Service
public class BatedorDePontoServices implements BatedorPontoService {

	@Autowired
	GarcomRepositories funcionarioRepository;

	@Autowired
	private BatedorPontoRepositories batedorPontorRepository;

	@Override
	public BatedorPontoDTO baterPontoDeFuncionario(Long userId, LocalDateTime horarioEntrada,
			LocalDateTime horarioSaida) throws Exception {
		var funcionario = funcionarioRepository.findById(userId)
				.orElseThrow(() -> new Exception("Usuário não pôde ser encontrado!"));
		BatedorPonto batedorPonto = new BatedorPonto();
		batedorPonto.setHorarioDeEntradaDia(horarioEntrada);
		batedorPonto.setHorarioDeSaidaDia(horarioSaida);
		batedorPonto.setUsuarioId(funcionario);
		batedorPonto.setTeveFalta(false);
		batedorPontorRepository.save(batedorPonto);
		return MyMapper.parseObject(batedorPonto, BatedorPontoDTO.class);
	}

	@Override
	public void registrarFaltaPorId(Long userId, LocalDate diaFalta, boolean teveFalta) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void calcularHorasTrabalhadasDeFuncionarioMes(Long funcionarioId, Long batedorPontoId) throws Exception {
		var funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(() -> new Exception("Funcionário não encontrado!");
		BatedorPonto batedor = batedorPontorRepository.findById(batedorPontoId).orElseThrow(() -> new Exception("Batedor de ponto não encontrado!"))
	
	}

}
