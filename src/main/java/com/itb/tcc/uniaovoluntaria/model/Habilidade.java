package com.itb.tcc.uniaovoluntaria.model;

public class Habilidade {
	private long id;
	
	private String descricao;
	private String nome;
	private long id_usuario;
	private boolean statusHamilidade;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public boolean isStatusHamilidade() {
		return statusHamilidade;
	}
	public void setStatusHamilidade(boolean statusHamilidade) {
		this.statusHamilidade = statusHamilidade;
	}
}
