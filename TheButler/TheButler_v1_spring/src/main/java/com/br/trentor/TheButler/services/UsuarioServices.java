package com.br.trentor.TheButler.services;

import com.br.trentor.TheButler.model.dtos.UsuarioDTO;

public interface UsuarioServices {

	UsuarioDTO criarNovoUsuario(UsuarioDTO novoUsuario) throws Exception;
	UsuarioDTO buscarUsuarioPorId(Long id) throws Exception;
	UsuarioDTO atualizarDadosUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception;
	void deletarUsuarioPorId(Long id) throws Exception;
}
