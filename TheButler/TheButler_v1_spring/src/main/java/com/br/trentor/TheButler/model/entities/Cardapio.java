package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cardapio")
public class Cardapio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "nome_de_cardapio")
	private String nomeDoCardapio;

	@OneToMany(mappedBy = "itemNoCardapio", fetch = FetchType.EAGER)
	private Set<Item> itemsNoCardapio = new TreeSet<>();

	public Cardapio(Long id, String nomeDoCardapio, Set<Item> itemsNoCardapio) {
		this.id = id;
		this.nomeDoCardapio = nomeDoCardapio;
		this.itemsNoCardapio = itemsNoCardapio;
	}

	public Cardapio() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoCardapio() {
		return nomeDoCardapio;
	}

	public void setNomeDoCardapio(String nomeDoCardapio) {
		this.nomeDoCardapio = nomeDoCardapio;
	}

	public Set<Item> getItemsNoCardapio() {
		return itemsNoCardapio;
	}

	public void setItemsNoCardapio(Set<Item> itemsNoCardapio) {
		this.itemsNoCardapio = itemsNoCardapio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemsNoCardapio, nomeDoCardapio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardapio other = (Cardapio) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemsNoCardapio, other.itemsNoCardapio)
				&& Objects.equals(nomeDoCardapio, other.nomeDoCardapio);
	}

}
