package com.caelum.clientdemo.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aluno")
public class Aluno {

	private String id;
	private String nome;
	private String curso;
	private Integer matricula;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", curso=" + curso + ", matricula=" + matricula + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	
}
