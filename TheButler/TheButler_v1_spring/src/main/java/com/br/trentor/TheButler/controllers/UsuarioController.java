package com.br.trentor.TheButler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trentor.TheButler.model.dtos.UsuarioDTO;
import com.br.trentor.TheButler.services.impl.UsuarioServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/usuario/v1/")
@Tag(name = "Usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServicesImpl userServices;
	
	@GetMapping(path = "procurar-por-id/{id}")
	public ResponseEntity<UsuarioDTO> obterUsuarioPorId(@PathVariable Long id) throws Exception {
		UsuarioDTO user = userServices.buscarUsuarioPorId(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@Operation(tags = "Usuarios", summary = "Cria um novo usuario no banco", description = "Faz a criação de um tipo qualquer dentro do banco")
	@PostMapping(path = "registrar-usuario")
	public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO novoUsuario) throws Exception {
		UsuarioDTO usuarioCadastrado = userServices.criarNovoUsuario(novoUsuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
	@Operation(tags = "Usuarios", summary = "Atualiza um usuario existente no banco", description = "Faz a atualização de um tipo qualquer dentro do banco")
	@PutMapping(path = "atualizar-usuario")
	public ResponseEntity<UsuarioDTO> atualizarUsuarioExistente(@RequestBody UsuarioDTO usuarioExistente) throws Exception {
		var user = userServices.atualizarDadosUsuarioExistente(usuarioExistente);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	
	@Operation(tags = "Usuarios", summary = "Deleta um usuario no banco", description = "Faz a deleção de um tipo qualquer dentro do banco")
	@DeleteMapping(path = "deletar-usuario/{id}")
	public ResponseEntity<?> deletarUsuarioPeloId(@PathVariable Long id) throws Exception {
		userServices.deletarUsuarioPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	
	public ResponseEntity<?> definirTipoDeUsuario(@RequestParam(value = "userName") String userName) throws Exception {
			var difined = userServices.definirTipoDeUsuario(userName);
			return null;
	}
	
	
	//IMPLEMENTAR RESTANTE DO CRUD
	
	//TERA OUTRAS FUNCÇÕES E SERA IMPLEMENTADO SPRING SECURITY POIS É UMA CLASSE QUE MEXE DIRETO NOS USUARIOS DO BANCO
}
