package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import com.br.trentor.TheButler.enums.StatusDeMesa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mesa")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "mesaDaComanda")
	private Comanda comandaDaMesa;
	
	@Enumerated(EnumType.STRING)
	private StatusDeMesa statusDeMesa;
	
	@Column(name = "numero_ocupantes")
	private Integer[] numeroOcupantes;
	
	private LocalDateTime inicioOcupacao;
	
	private LocalDateTime terminoOcupacao;

	public Mesa(Long id, Comanda comandaDaMesa, StatusDeMesa statusDeMesa, Integer[] numeroOcupantes,
			LocalDateTime inicioOcupacao, LocalDateTime terminoOcupacao) {
		this.id = id;
		this.comandaDaMesa = comandaDaMesa;
		this.statusDeMesa = statusDeMesa;
		this.numeroOcupantes = numeroOcupantes;
		this.inicioOcupacao = inicioOcupacao;
		this.terminoOcupacao = terminoOcupacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comanda getComandaDaMesa() {
		return comandaDaMesa;
	}

	public void setComandaDaMesa(Comanda comandaDaMesa) {
		this.comandaDaMesa = comandaDaMesa;
	}

	public StatusDeMesa getStatusDeMesa() {
		return statusDeMesa;
	}

	public void setStatusDeMesa(StatusDeMesa statusDeMesa) {
		this.statusDeMesa = statusDeMesa;
	}

	public Integer[] getNumeroOcupantes() {
		return numeroOcupantes;
	}

	public void setNumeroOcupantes(Integer[] numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}

	public LocalDateTime getInicioOcupacao() {
		return inicioOcupacao;
	}

	public void setInicioOcupacao(LocalDateTime inicioOcupacao) {
		this.inicioOcupacao = inicioOcupacao;
	}

	public LocalDateTime getTerminoOcupacao() {
		return terminoOcupacao;
	}

	public void setTerminoOcupacao(LocalDateTime terminoOcupacao) {
		this.terminoOcupacao = terminoOcupacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", comandaDaMesa=" + comandaDaMesa + ", statusDeMesa=" + statusDeMesa
				+ ", numeroOcupantes=" + Arrays.toString(numeroOcupantes) + ", inicioOcupacao=" + inicioOcupacao
				+ ", terminoOcupacao=" + terminoOcupacao + "]";
	}
	
	
	
}
