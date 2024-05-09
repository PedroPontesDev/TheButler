package com.br.trentor.TheButler.services;

import com.br.trentor.TheButler.model.dtos.GarcomDTO;

public interface GarcomServices {

	GarcomDTO criarNovoUsuario(GarcomDTO novoUsuario) throws Exception;
	GarcomDTO buscarUsuarioPorId(Long id) throws Exception;
	GarcomDTO atualizarDadosUsuarioExistente(GarcomDTO usuarioExistente) throws Exception;
	void deletarUsuarioPorId(Long id) throws Exception;
}
