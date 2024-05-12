package com.br.trentor.TheButler.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.model.entities.Garcom;
import com.br.trentor.TheButler.model.entities.Usuario;
import com.br.trentor.TheButler.model.mapper.MyMapper;
import com.br.trentor.TheButler.repositories.GarcomRepositories;
import com.br.trentor.TheButler.services.UsuarioServices;
import com.br.trentor.TheButler.services.*;

@Service
public class GarcomServicesImpl implements GarcomServices {

	@Autowired
	private GarcomRepositories garcomRepository;

	@Override
	public GarcomDTO criarNovoUsuario(GarcomDTO novoUsuario) throws Exception {
		if(novoUsuario == null) throw new Exception("Dados de garçom inválido, tente novamente mais tarde!");
		Garcom newGarcom = MyMapper.parseObject(novoUsuario, Garcom.class);
		newGarcom = garcomRepository.save(newGarcom);
		return MyMapper.parseObject(newGarcom, GarcomDTO.class);
	}

	@Override
	public GarcomDTO buscarUsuarioPorId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GarcomDTO atualizarDadosUsuarioExistente(GarcomDTO usuarioExistente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarUsuarioPorId(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
