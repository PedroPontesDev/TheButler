package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comanda")
public class Comanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_da_comanda")
	private String nomeComanda;

	@OneToMany(mappedBy = "comandaDoItem", fetch = FetchType.EAGER)
	private Set<Item> itemComanda = new TreeSet<>();

	@Column(name = "comanda_esta_aberta")
	private Boolean estaEmAberta;

	@Column(name = "valor_total_comanda")
	private Long valorConta;

	@OneToOne(mappedBy = "comanda")
	private Garcom garcom;


	public Comanda(Long id, String nomeComanda, Set<Item> itemComanda, Boolean estaEmAberta, Long valorConta,
			Garcom garcom) {
		this.id = id;
		this.nomeComanda = nomeComanda;
		this.itemComanda = itemComanda;
		this.estaEmAberta = estaEmAberta;
		this.valorConta = valorConta;
		this.garcom = garcom;
	}
	
	public Comanda() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeComanda() {
		return nomeComanda;
	}

	public void setNomeComanda(String nomeComanda) {
		this.nomeComanda = nomeComanda;
	}

	public Set<Item> getItemComanda() {
		return itemComanda;
	}

	public void setItemComanda(Set<Item> itemComanda) {
		this.itemComanda = itemComanda;
	}

	public Boolean getEstaEmAberta() {
		return estaEmAberta;
	}

	public void setEstaEmAberta(Boolean estaEmAberta) {
		this.estaEmAberta = estaEmAberta;
	}

	public Long getValorConta() {
		return valorConta;
	}

	public void setValorConta(Long valorConta) {
		this.valorConta = valorConta;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
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
		Comanda other = (Comanda) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", nomeComanda=" + nomeComanda + ", itemComanda=" + itemComanda + ", estaEmAberta="
				+ estaEmAberta + ", valorConta=" + valorConta + ", garcom=" + garcom + "]";
	}

	

}
