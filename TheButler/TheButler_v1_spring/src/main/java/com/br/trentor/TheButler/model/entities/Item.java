package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "imgUrl")
	private String imgUrl;

	@Column(name = "nome")
	private String nomeDoItem;

	@Column(name = "preço_item")
	private Double preço;

	@Column(name = "quantidades")
	private Integer quantidade;

	@Column(name = "esta_disponivel")
	private Boolean estaDisponivel;
	
	@ManyToOne
	private Cardapio itemDeCardapio;

	public Item(Long id, String imgUrl, String nomeDoItem, Double preço, Integer quantidade, Boolean estaDisponivel, Cardapio itemDeCardapio) {
		this.id = id;
		this.imgUrl = imgUrl;
		this.nomeDoItem = nomeDoItem;
		this.preço = preço;
		this.quantidade = quantidade;
		this.estaDisponivel = estaDisponivel;
		this.itemDeCardapio = itemDeCardapio;
	}

	public Item() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNomeDoItem() {
		return nomeDoItem;
	}

	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Boolean getEstaDisponivel() {
		return estaDisponivel;
	}

	public void setEstaDisponivel(Boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}

	public Cardapio getItemDeCardapio() {
		return itemDeCardapio;
	}

	public void setItemDeCardapio(Cardapio itemDeCardapio) {
		this.itemDeCardapio = itemDeCardapio;
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
		Item other = (Item) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", imgUrl=" + imgUrl + ", nomeDoItem=" + nomeDoItem + ", preço=" + preço
				+ ", quantidade=" + quantidade + ", estaDisponivel=" + estaDisponivel + "]";
	}

}
