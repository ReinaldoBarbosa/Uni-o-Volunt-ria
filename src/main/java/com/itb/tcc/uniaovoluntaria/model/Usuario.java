package com.itb.tcc.uniaovoluntaria.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Incremento de 1 em 1
	private long id;
	
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private LocalDate data_nasc;
	private String senha;
	private byte[] foto_perfil;
	private boolean status_usuario;

	//Getters e Setters 
	//(id=${usuario.id})
	//Id
	
	public byte[] getFoto_perfil() {
		return foto_perfil;
	}

	public void setFoto_perfil(byte[] foto_perfil) {
		this.foto_perfil = foto_perfil;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isStatus() {
		return status_usuario;
	}

	public void setStatus(boolean statusUsuario) {
		this.status_usuario = statusUsuario;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	//Nome
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Email
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Cpf
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	//Data de nascimento 
	
	public LocalDate getDataDeNasci() {
		return data_nasc;
	}
	
	public void setDataDeNasci(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	
	//Senha 
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}



	public void setId(long id) {
		this.id = id;
	}

	
	
	
}
