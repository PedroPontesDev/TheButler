package com.br.trentor.TheButler.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_batedor_ponto")
public class BatedorPonto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Autowired
	private LocalDateTime horarioDeEntradaDia;
	@Autowired
	private LocalDateTime horarioDeSaidaDia;

	@OneToOne
	private Usuario usuario;

	@Autowired
	private LocalDate diaFalta;

	private boolean teveFalta;

	public BatedorPonto(Long id, LocalDateTime horarioDeEntradaDia, LocalDateTime horarioDeSaidaDia, Usuario usuario,
			LocalDate diaFalta, boolean teveFalta) {
		this.id = id;
		this.horarioDeEntradaDia = horarioDeEntradaDia;
		this.horarioDeSaidaDia = horarioDeSaidaDia;
		this.usuario = usuario;
		this.diaFalta = diaFalta;
		this.teveFalta = teveFalta;
	}

	public BatedorPonto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorarioDeEntradaDia() {
		return horarioDeEntradaDia;
	}

	public void setHorarioDeEntradaDia(LocalDateTime horarioDeEntradaDia) {
		this.horarioDeEntradaDia = horarioDeEntradaDia;
	}

	public LocalDateTime getHorarioDeSaidaDia() {
		return horarioDeSaidaDia;
	}

	public void setHorarioDeSaidaDia(LocalDateTime horarioDeSaidaDia) {
		this.horarioDeSaidaDia = horarioDeSaidaDia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuarioId(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDiaFalta() {
		return diaFalta;
	}

	public void setDiaFalta(LocalDate diaFalta) {
		this.diaFalta = diaFalta;
	}

	public boolean isTeveFalta() {
		return teveFalta;
	}

	public void setTeveFalta(boolean teveFalta) {
		this.teveFalta = teveFalta;
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
		BatedorPonto other = (BatedorPonto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BatedorPonto [id=" + id + ", horarioDeEntradaDia=" + horarioDeEntradaDia + ", horarioDeSaidaDia="
				+ horarioDeSaidaDia + ", usuario=" + usuario + ", diaFalta=" + diaFalta + ", teveFalta=" + teveFalta
				+ "]";
	}

	
	
}
