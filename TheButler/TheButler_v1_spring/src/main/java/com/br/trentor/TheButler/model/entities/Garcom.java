package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
@PrimaryKeyJoinColumn(name = "id")
public class Garcom extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "horario_dia_entrada")
	private LocalDateTime horarioDiaEntrada;

	@Column(name = "horario_dia_saida")
	private LocalDateTime horarioDiaSaida;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_gorjeta_de_garcons", joinColumns = @JoinColumn(name = "garcom_id"), inverseJoinColumns = @JoinColumn(name = "gorjeta_id"))
	private List<Gorjeta> gorjetas = new ArrayList<>();

	@OneToOne(mappedBy = "garcom")
	private Comanda comanda;

	@Column(name = "salario_mensal")
	private Double salario;

	@OneToOne
	private Cardapio cardapio;

	public Garcom(Long id, String userName, String password, String fullName, BigDecimal cpf,
			LocalDateTime horarioDiaEntrada, LocalDateTime horarioDiaSaida, List<Gorjeta> gorjetas, Comanda comanda,
			Double salario, Cardapio cardapio) {
		super(id, userName, password, fullName, cpf);
		this.horarioDiaEntrada = horarioDiaEntrada;
		this.horarioDiaSaida = horarioDiaSaida;
		this.gorjetas = gorjetas;
		this.comanda = comanda;
		this.salario = salario;
		this.cardapio = cardapio;
	}

	public Garcom() {
		super();
	}

	public LocalDateTime getHorarioDiaEntrada() {
		return horarioDiaEntrada;
	}

	public void setHorarioDiaEntrada(LocalDateTime horarioDiaEntrada) {
		this.horarioDiaEntrada = horarioDiaEntrada;
	}

	public LocalDateTime getHorarioDiaSaida() {
		return horarioDiaSaida;
	}

	public void setHorarioDiaSaida(LocalDateTime horarioDiaSaida) {
		this.horarioDiaSaida = horarioDiaSaida;
	}

	public List<Gorjeta> getGorjetas() {
		return gorjetas;
	}

	public void setGorjetas(List<Gorjeta> gorjetas) {
		this.gorjetas = gorjetas;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(comanda, gorjetas, horarioDiaEntrada, horarioDiaSaida, salario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garcom other = (Garcom) obj;
		return Objects.equals(comanda, other.comanda) && Objects.equals(gorjetas, other.gorjetas)
				&& Objects.equals(horarioDiaEntrada, other.horarioDiaEntrada)
				&& Objects.equals(horarioDiaSaida, other.horarioDiaSaida) && Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Garcom [horarioDiaEntrada=" + horarioDiaEntrada + ", horarioDiaSaida=" + horarioDiaSaida + ", gorjetas="
				+ gorjetas + ", comanda=" + comanda + ", salario=" + salario + "]";
	}

}
