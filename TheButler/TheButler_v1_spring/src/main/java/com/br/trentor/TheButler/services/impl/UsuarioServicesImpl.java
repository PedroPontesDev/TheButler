package com.br.trentor.TheButler.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.TheButler.model.dtos.UsuarioDTO;
import com.br.trentor.TheButler.model.entities.Usuario;
import com.br.trentor.TheButler.model.mapper.MyMapper;
import com.br.trentor.TheButler.repositories.UsuarioRepositories;
import com.br.trentor.TheButler.services.UsuarioServices;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	private UsuarioRepositories userRepository;

	@Override
	@Transactional
	public UsuarioDTO criarNovoUsuario(UsuarioDTO novoUsuario) throws Exception {
		if (novoUsuario == null)
			throw new Exception("Dados inválidos, tente novamente!");
		var novoUser = MyMapper.parseObject(novoUsuario, Usuario.class);
		userRepository.save(novoUser);
		return MyMapper.parseObject(novoUser, UsuarioDTO.class);

	}

	@Override
	@Transactional
	public UsuarioDTO buscarUsuarioPorId(Long id) throws Exception {
		var usuarioNoBanco = userRepository.findById(id);
		if (!usuarioNoBanco.isPresent())
			throw new Exception("Usuário não encontrado, verifique o código identificador e tente novamente!");
		Usuario user = usuarioNoBanco.get();
		UsuarioDTO dto = MyMapper.parseObject(user, UsuarioDTO.class);
		return dto;
	}

	@Override
	@Transactional
	public UsuarioDTO atualizarDadosUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception {
		var usuarioNoBanco = userRepository.findById(usuarioExistente.getId());
		if (!usuarioNoBanco.isPresent())
			throw new Exception("Usuário não encontrado, verifique o código identificador e tente novamente!");
		Usuario user = usuarioNoBanco.get();
		user.setCpf(usuarioExistente.getCpf());
		user.setFullName(usuarioExistente.getFullName());
		user.setUserName(usuarioExistente.getUserName());
		user.setPassword(usuarioExistente.getPassword());
		UsuarioDTO dto = MyMapper.parseObject(user, UsuarioDTO.class);
		return dto;

	}

	@Override
	@Transactional
	public void deletarUsuarioPorId(Long id) throws Exception {
		var user = userRepository.findById(id);
		if (user.isPresent()) {
			Usuario usuarioDoBanco = user.get();
			userRepository.delete(usuarioDoBanco);
		} else {
			throw new Exception("Usuário não encontrado, verifique o código identificador e tente novamente!");
		}
	}
	
	public Object definirTipoDeUsuario(String userName) throws Exception {
		Object finded = userRepository.findByUserName(userName);
		if(finded == null) throw new Exception("Usuário não encontrado, verifique o username e tente novamente!");
		var aDefenir = MyMapper.parseObject(finded.getClass(), null);
		
		//Deixar o adm escolher que tipo de user defininr
		//A implementar com spring Security
		return null;
	}

}
