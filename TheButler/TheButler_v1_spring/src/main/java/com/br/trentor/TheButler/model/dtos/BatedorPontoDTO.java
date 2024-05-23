package com.br.trentor.TheButler.model.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class BatedorPontoDTO {

	private Long id;
	private LocalDateTime horarioDeEntradaDia;
	private LocalDateTime horarioDeSaidaDia;
	private UsuarioDTO usuario;
	private LocalDate diaFalta;
	private boolean teveFalta;

	public BatedorPontoDTO() {
	}

	public BatedorPontoDTO(Long id, LocalDateTime horarioDeEntradaDia, LocalDateTime horarioDeSaidaDia,
			UsuarioDTO usuario, LocalDate diaFalta, boolean teveFalta) {
		this.id = id;
		this.horarioDeEntradaDia = horarioDeEntradaDia;
		this.horarioDeSaidaDia = horarioDeSaidaDia;
		this.usuario = usuario;
		this.diaFalta = diaFalta;
		this.teveFalta = teveFalta;
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

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
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
		BatedorPontoDTO other = (BatedorPontoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BatedorPontoDTO [id=" + id + ", horarioDeEntradaDia=" + horarioDeEntradaDia + ", horarioDeSaidaDia="
				+ horarioDeSaidaDia + ", usuario=" + usuario + ", diaFalta=" + diaFalta + ", teveFalta=" + teveFalta
				+ "]";
	}

	
	
}
