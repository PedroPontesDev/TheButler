package com.br.trentor.TheButler.model.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.br.trentor.TheButler.model.entities.Comanda;
import com.br.trentor.TheButler.model.entities.Gorjeta;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GarcomDTO extends UsuarioDTO {
	private static final long serialVersionUID = 1L;

	@JsonProperty("usuario")
	private String userName;

	@JsonProperty("senha")
	private String password;

	@JsonProperty("NomeCompleto")
	private String fullName;

	private BigDecimal cpf;

	private LocalDateTime totalHorasTrabalhadasMes;

	private List<Gorjeta> gorjeta = new ArrayList<>();

	private Comanda comanda;

	private Double salario;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
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

	public LocalDateTime getTotalHorasTrabalhadasMes() {
		return totalHorasTrabalhadasMes;
	}

	public void setTotalHorasTrabalhadasMes(LocalDateTime totalHorasTrabalhadasMes) {
		this.totalHorasTrabalhadasMes = totalHorasTrabalhadasMes;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(comanda, cpf, fullName, gorjeta, password, salario, totalHorasTrabalhadasMes, userName);
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
		GarcomDTO other = (GarcomDTO) obj;
		return Objects.equals(comanda, other.comanda) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gorjeta, other.gorjeta)
				&& Objects.equals(password, other.password) && Objects.equals(salario, other.salario)
				&& Objects.equals(totalHorasTrabalhadasMes, other.totalHorasTrabalhadasMes)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "GarcomDTO [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", cpf=" + cpf
				+ ", totalHorasTrabalhadasMes=" + totalHorasTrabalhadasMes + ", gorjeta=" + gorjeta + ", comanda="
				+ comanda + ", salario=" + salario + "]";
	}

}
