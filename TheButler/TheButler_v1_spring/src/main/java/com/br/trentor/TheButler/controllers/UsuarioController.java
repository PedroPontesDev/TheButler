package com.br.trentor.TheButler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.trentor.TheButler.services.impl.UsuarioServicesImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/users/v1/")
@Tag(name = "Usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServicesImpl userServices;
	
}
