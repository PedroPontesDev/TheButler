package com.br.trentor.TheButler.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.model.entities.Garcom;
import com.br.trentor.TheButler.model.mapper.MyMapper;
import com.br.trentor.TheButler.repositories.GarcomRepositories;
import com.br.trentor.TheButler.services.GarcomServices;

import jakarta.transaction.Transactional;

@Service
public class GarcomServicesImpl implements GarcomServices {

	@Autowired
	private GarcomRepositories garcomRepository;
	
	@Override
	@Transactional
	public GarcomDTO registrarNovoGarcom(GarcomDTO novoUsuario) throws Exception {
		if (novoUsuario == null)
			throw new Exception("Dados de garçom inválido, tente novamente mais tarde!");
		GarcomDTO novoGarcom = novoUsuario;
		Garcom garcom = MyMapper.parseObject(novoGarcom, Garcom.class);
		garcom.setUserName(novoUsuario.getUserName());
		garcom.setPassword(novoUsuario.getPassword());
		garcom.setFullName(novoUsuario.getFullName());
		garcom.setCpf(novoUsuario.getCpf());
		garcom.setSalario(novoUsuario.getSalario());
		garcom.setComanda(novoUsuario.getComanda());
		garcom.setGorjetas(new ArrayList<>());
		garcomRepository.save(garcom);
		return MyMapper.parseObject(garcom, GarcomDTO.class);
	}

	@Override
	public GarcomDTO buscarGarcomPorId(Long id) throws Exception {
		var finder = garcomRepository.findById(id);
		if (!finder.isPresent())
			throw new Exception("Garcom não encontrado, verifique o identificador unico e tente novamente!");
		Garcom garcom = finder.get();
		var dto = MyMapper.parseObject(garcom, GarcomDTO.class);
		return dto;
	}

	@Override
	public GarcomDTO atualizarDadosGarcomExistente(GarcomDTO garcomExistente) throws Exception {
		var finder = garcomRepository.findById(garcomExistente.getId());
		if (!finder.isPresent())
			throw new Exception("Garcom não encontrado, verifique o identificador único e tente novamente!");
		Garcom garcom = finder.get();
		garcom.setUserName(garcomExistente.getUserName());
		garcom.setPassword(garcomExistente.getPassword());
		garcom.setFullName(garcomExistente.getFullName());
		garcom.setCpf(garcomExistente.getCpf());
		garcom.setComanda(garcomExistente.getComanda());
		garcom.setSalario(garcomExistente.getSalario());
		garcom.setGorjetas(new ArrayList<>());
		garcomRepository.save(garcom);
		var dto = MyMapper.parseObject(garcom, GarcomDTO.class);
		return dto;

	}

	@Override
	public void deletarGarcomPorId(Long id) throws Exception {
		var finder = garcomRepository.findById(id);
		if (finder.isPresent())
			garcomRepository.deleteById(id);
		throw new Exception("Garcom não encontrado, verifique o identificador único e tente novamente!");
	}
	
}
