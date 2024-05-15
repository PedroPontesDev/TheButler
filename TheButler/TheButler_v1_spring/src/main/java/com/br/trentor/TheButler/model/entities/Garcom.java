package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_gorjeta_de_garcons", joinColumns = @JoinColumn(name = "garcom_id"), inverseJoinColumns = @JoinColumn(name = "gorjeta_id"))
	private List<Gorjeta> gorjetas = new ArrayList<>();

	@OneToOne(mappedBy = "garcom")
	private Comanda comanda;

	@Column(name = "salario_mensal")
	private Double salario;

	public Garcom(Long id, String userName, String password, String fullName, BigDecimal cpf, List<Gorjeta> gorjetas, Comanda comanda, Double salario) {
		super(id, userName, password, fullName, cpf);
		this.gorjetas = gorjetas;
		this.comanda = comanda;
		this.salario = salario;
	}

	public Garcom() {
		super();
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(comanda, gorjetas, salario);
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
				&& Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Garcom [gorjetas=" + gorjetas + ", comanda=" + comanda + ", salario=" + salario + "]";
	}

	

}
