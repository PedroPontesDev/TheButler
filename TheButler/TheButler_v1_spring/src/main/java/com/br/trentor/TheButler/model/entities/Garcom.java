package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
public class Garcom extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "cpf")
	private BigDecimal cpf;

	@Column(name = "horas_trabalhadas_mes")
	private LocalDateTime totalHorasTrabalhadasMes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_gorjeta_de_garçons", joinColumns = @JoinColumn(name = "gorjeta.id"), inverseJoinColumns = @JoinColumn(name = "garcom.id"))
	private List<Gorjeta> gorjeta = new ArrayList<>();

	@OneToOne(mappedBy = "garcom")
	private Comanda comanda;

	@Column(name = "salario_mensal")
	private Double salario;

	public Garcom(Long id, String userName, String password, String fullName, BigDecimal cpf,
			LocalDateTime totalHorasTrabalhadasMes, List<Gorjeta> gorjeta, Comanda comanda, Double salario) {
		super(id, userName, password, fullName, cpf);
		this.id = id;
		this.totalHorasTrabalhadasMes = totalHorasTrabalhadasMes;
		this.gorjeta = gorjeta;
		this.comanda = comanda;
		this.salario = salario;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.cpf = cpf;
	}
	
	public Garcom() {
		super();
	}

	public LocalDateTime getTotalHorasTrabalhadasMes() {
		return totalHorasTrabalhadasMes;
	}

	public void setTotalHorasTrabalhadasMes(LocalDateTime totalHorasTrabalhadasMes) {
		this.totalHorasTrabalhadasMes = totalHorasTrabalhadasMes;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Gorjeta> getGorjeta() {
		return gorjeta;
	}

	public void setGorjeta(List<Gorjeta> gorjeta) {
		this.gorjeta = gorjeta;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return super.getFullName();
	}

	@Override
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		super.setFullName(fullName);
	}

	@Override
	public BigDecimal getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}

	@Override
	public void setCpf(BigDecimal cpf) {
		// TODO Auto-generated method stub
		super.setCpf(cpf);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(comanda, gorjeta, salario, totalHorasTrabalhadasMes);
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
		return Objects.equals(comanda, other.comanda) && Objects.equals(gorjeta, other.gorjeta)
				&& Objects.equals(salario, other.salario)
				&& Objects.equals(totalHorasTrabalhadasMes, other.totalHorasTrabalhadasMes);
	}

	@Override
	public String toString() {
		return "Garcom [totalHorasTrabalhadasMes=" + totalHorasTrabalhadasMes + ", salario=" + salario + ", gorjeta="
				+ gorjeta + ", comanda=" + comanda + "]";
	}

}
