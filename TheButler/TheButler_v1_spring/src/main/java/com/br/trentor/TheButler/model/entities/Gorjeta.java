package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_gorjeta")
public class Gorjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "comissao_garcom")
	private Double comissao = 0.10;

	@Column(name = "foi_paga")
	private Boolean foiPaga;

	public Gorjeta(Long id, Double comissao, Boolean foiPaga) {
		this.id = id;
		this.comissao = comissao;
		this.foiPaga = foiPaga;
	}
	
	public Gorjeta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Boolean getFoiPaga() {
		return foiPaga;
	}

	public void setFoiPaga(Boolean foiPaga) {
		this.foiPaga = foiPaga;
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
		Gorjeta other = (Gorjeta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Gorjeta [id=" + id + ", comissao=" + comissao + ", foiPaga=" + foiPaga + "]";
	}
	
	

}
