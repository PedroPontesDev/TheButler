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
import com.br.trentor.TheButler.services.impl.GarcomServicesImpl;
import com.br.trentor.TheButler.services.impl.UsuarioServicesImpl;

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
	
	//IMPLEMENTAR RESTANTE DO CRUD
	
	//TERA OUTRAS FUNCÇÕES E SERA IMPLEMENTADO SPRING SECURITY POIS É UMA CLASSE QUE MEXE DIRETO NOS USUARIOS DO BANCO
}
