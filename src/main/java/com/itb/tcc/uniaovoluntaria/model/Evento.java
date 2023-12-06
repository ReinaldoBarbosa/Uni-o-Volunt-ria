package com.itb.tcc.uniaovoluntaria.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {
	
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Incremento de 1 em 1
	private long id;
	
	private String nome;
	private LocalDate data_evento;
	private String vagas;
	private String horaInicio;
	private String infos;
	private String cep;
	private String numero;
	private byte[] foto;
	private boolean statusEvento;
	private long id_ong;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData() {
		return data_evento;
	}
	
	public void setData(LocalDate dataEvento) {
		this.data_evento = dataEvento;
	}
	public String getVagas() {
		return vagas;
	}
	public void setVagas(String vagas) {
		this.vagas = vagas;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public boolean isStatusEvento() {
		return statusEvento;
	}
	public void setStatusEvento(boolean statusEvento) {
		this.statusEvento = statusEvento;
	}
	
	
	public long getId_ong() {
		return id_ong;
	}
	public void setId_ong(long id_ong) {
		this.id_ong = id_ong;
	}
	
}
