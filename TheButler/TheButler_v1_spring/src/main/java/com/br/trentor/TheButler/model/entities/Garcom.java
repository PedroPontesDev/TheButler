package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
public class Garcom extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "horas_trabalhadas_mes")
	private LocalDateTime totalHorasTrabalhadasMes;
	@Column(name = "salario_mensal")
	private Double salario;
	
	@ManyToMany
	@JoinTable(name = "tb_gorjeta_de_garçons", 
	joinColumns = @JoinColumn(name = "gorjeta.id"), inverseJoinColumns = @JoinColumn(name = "garcom.id"))
	private Gorjeta gorjeta;
	
	private Comanda comanda;
	
	
	public Garcom(Long id, String userName, String password, String fullName, BigDecimal cpf) {
		super(id, userName, password, fullName, cpf);
		// TODO Auto-generated constructor stub
	}

	
	

}
