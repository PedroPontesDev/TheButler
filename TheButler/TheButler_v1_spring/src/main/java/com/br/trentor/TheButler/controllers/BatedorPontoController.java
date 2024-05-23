package com.br.trentor.TheButler.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.br.trentor.TheButler.model.dtos.BatedorPontoDTO;
import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.model.dtos.GarcomDTO;
import com.br.trentor.TheButler.services.impl.BatedorDePontoServices;
import com.br.trentor.TheButler.services.impl.GarcomServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/batedor-ponto/v1/")
@Tag(name = "BatedorPonto")
public class BatedorPontoController {

	@Autowired
	private BatedorDePontoServices batedorPontoServices;

	@PostMapping(path = "bater-ponto/{userId}")
	public ResponseEntity<BatedorPontoDTO> baterPontoDeFuncionario(@PathVariable Long userId,
			 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime horarioEntrada,
             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime horarioSaida) throws Exception {
		var pointer = batedorPontoServices.baterPontoDeFuncionario(userId, horarioEntrada, horarioSaida);
		return new ResponseEntity<>(pointer, HttpStatus.CREATED);

	}

}
