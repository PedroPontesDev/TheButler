package com.br.trentor.TheButler.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.model.dtos.UsuarioDTO;
import com.br.trentor.TheButler.model.mapper.MyMapper;
import com.br.trentor.TheButler.repositories.GarcomRepositories;
import com.br.trentor.TheButler.repositories.UsuarioRepositories;
import com.br.trentor.TheButler.services.GarcomServices;

@Service
public class GarcomServicesImpl implements GarcomServices {

	@Autowired
	private GarcomRepositories garcomRepository;

	@Autowired
	private UsuarioRepositories userRepository;
	
	@Autowired
	private UsuarioServicesImpl userServices;
	
	@Override
	public GarcomDTO criarNovoGarcom(GarcomDTO novoUsuario) throws Exception {
		if(novoUsuario == null) throw new Exception("Dados de garçom inválido, tente novamente mais tarde!");
		//Mapear 
		UsuarioDTO copyValues = new UsuarioDTO();
		copyValues.setFullName(novoUsuario.getFullName());
		copyValues.setCpf(novoUsuario.getCpf());
		copyValues.setUserName(novoUsuario.getUserName());
		copyValues.setPassword(novoUsuario.getPassword());
		userServices.criarNovoUsuario(novoUsuario);
//
		GarcomDTO novoGarcom = novoUsuario;
		
		
		
		
		
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
