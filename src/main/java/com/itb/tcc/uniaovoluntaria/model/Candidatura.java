package com.itb.tcc.uniaovoluntaria.model;

import java.time.LocalTime;

public class Candidatura {
	private long id;
	
	private LocalTime data_cadast;
	private LocalTime data_admissao;
	private long id_usuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalTime getData_cadast() {
		return data_cadast;
	}
	public void setData_cadast(LocalTime data_cadast) {
		this.data_cadast = data_cadast;
	}
	public LocalTime getData_admissao() {
		return data_admissao;
	}
	public void setData_admissao(LocalTime data_admissao) {
		this.data_admissao = data_admissao;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public long getId_evento() {
		return id_evento;
	}
	public void setId_evento(long id_evento) {
		this.id_evento = id_evento;
	}
	public boolean isStatusCadastro() {
		return statusCadastro;
	}
	public void setStatusCadastro(boolean statusCadastro) {
		this.statusCadastro = statusCadastro;
	}
	private long id_evento;
	private boolean statusCadastro;
}
