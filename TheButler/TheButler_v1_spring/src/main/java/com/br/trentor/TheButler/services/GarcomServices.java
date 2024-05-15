package com.br.trentor.TheButler.services;

import com.br.trentor.TheButler.model.dtos.GarcomDTO;

public interface GarcomServices {

	GarcomDTO registrarNovoGarcom(GarcomDTO novoUsuario) throws Exception;
	GarcomDTO buscarGarcomPorId(Long id) throws Exception;
	GarcomDTO atualizarDadosGarcomExistente(GarcomDTO garcomExistente) throws Exception;
	void deletarGarcomPorId(Long id) throws Exception;
	
}
