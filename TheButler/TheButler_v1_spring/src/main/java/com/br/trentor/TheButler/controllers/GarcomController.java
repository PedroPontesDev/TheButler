package com.br.trentor.TheButler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.services.impl.GarcomServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/garcom/v1/")
@Tag(name = "Garçom")
public class GarcomController {

	@Autowired
	private GarcomServicesImpl garcomServices;

	@Operation(tags = "Garçom", summary = "Cria um novo garçom no banco", description = "Faz a criação de um tipo garçom dentro do banco")
	@PostMapping(path = "registrar-garcom")
	public ResponseEntity<GarcomDTO> criarUsuario(@RequestBody GarcomDTO novoUsuario) throws Exception {
		GarcomDTO usuarioCadastrado = garcomServices.registrarNovoGarcom(novoUsuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}

	@Operation(tags = "Garçom", summary = "Atualiza um usuario existente no banco", description = "Faz a atualização de um tipo qualquer dentro do banco")
	@PutMapping(path = "atualizar-usuario")
	public ResponseEntity<GarcomDTO> atualizarUsuarioExistente(@RequestBody GarcomDTO usuarioExistente)
			throws Exception {
		var user = garcomServices.atualizarDadosGarcomExistente(usuarioExistente);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@Operation(tags = "Garçom", summary = "Deleta um usuario no banco", description = "Faz a deleção de um tipo qualquer dentro do banco")
	@DeleteMapping(path = "deletar-usuario/{id}")
	public ResponseEntity<?> deletarUsuarioPeloId(@PathVariable Long id) throws Exception {
		garcomServices.deletarGarcomPorId(id);
		return ResponseEntity.noContent().build();
	}

	// TERA OUTRAS FUNCÇÕES E SERA IMPLEMENTADO SPRING SECURITY POIS É UMA CLASSE
	// QUE MEXE DIRETO NOS Garçom DO BANCO
}
