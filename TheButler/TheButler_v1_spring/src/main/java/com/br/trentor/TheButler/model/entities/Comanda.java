package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comanda")
public class Comanda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome_da_comanda")
	private String nomeComanda;
	
	@OneToOne
	private Garcom garcom;
	
}
