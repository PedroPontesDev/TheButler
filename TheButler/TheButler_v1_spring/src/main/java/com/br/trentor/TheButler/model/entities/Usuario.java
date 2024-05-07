package com.br.trentor.TheButler.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
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

	public Usuario(Long id, String userName, String password, String fullName, BigDecimal cpf) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.cpf = cpf;
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
		return Objects.hash(id, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", cpf=" + cpf + "]";
	}

}
