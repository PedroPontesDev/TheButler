package com.br.trentor.TheButler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.trentor.TheButler.model.dtos.UsuarioDTO;
import com.br.trentor.TheButler.services.impl.UsuarioServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/users/v1/")
@Tag(name = "Usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServicesImpl userServices;
	
	@Operation(tags = "Usuarios", summary = "Cria um novo usuario no banco")
	@PostMapping(path = "registrar-usuario")
	public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO novoUsuario) throws Exception {
		UsuarioDTO usuarioCadastrado = userServices.criarNovoUsuario(novoUsuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
}
