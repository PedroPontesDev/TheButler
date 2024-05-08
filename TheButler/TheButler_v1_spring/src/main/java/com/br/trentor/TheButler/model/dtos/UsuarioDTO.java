package com.br.trentor.TheButler.model.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder("id, username, password, fullName, cpf")
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonProperty("usuario")
	private String userName;
	
	@JsonProperty("senha")
	private String password;
	
	@JsonProperty("NomeCompleto")
	private String fullName;
	
	private BigDecimal cpf;

	public UsuarioDTO(Long id, String userName, String password, String fullName, BigDecimal cpf) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.cpf = cpf;
	}

	public UsuarioDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigDecimal getCpf() {
		return cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
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
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", cpf=" + cpf + "]";
	}

}
