package com.br.trentor.TheButler.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.TheButler.model.dtos.UsuarioDTO;
import com.br.trentor.TheButler.model.entities.Usuario;
import com.br.trentor.TheButler.model.mapper.MyMapper;
import com.br.trentor.TheButler.repositories.UsuarioRepositories;
import com.br.trentor.TheButler.services.UsuarioServices;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	private UsuarioRepositories userRepository;
	
	@Override
	public UsuarioDTO criarNovoUsuario(UsuarioDTO novoUsuario) throws Exception {
		if (novoUsuario == null) throw new Exception("Dados inválidos, tente novamente!");
		var novoUser = MyMapper.parseObject(novoUsuario, Usuario.class);
		userRepository.save(novoUser);
		return MyMapper.parseObject(novoUser, UsuarioDTO.class);
		
	}

	@Override
	public UsuarioDTO buscarUsuarioPorId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO atualizarDadosUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarUsuarioPorId(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
