package com.IF.entidades;

public class Aluno {
	
	// Atributos
	
	private String Nome;
	private boolean ID;
	private String NumMatricula;
	
	// Construtores
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, boolean ID, String NumMatricula) {
		this.Nome = nome;
		this.ID = ID;
		this.NumMatricula = NumMatricula;
	}
	
	// Metodos Públicos
	
	public String toString() {
		return this.Nome;
	}
	
	// Get and Set

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public boolean isID() {
		return ID;
	}

	public void setID(boolean iD) {
		ID = iD;
	}

	public String getNumMatricula() {
		return NumMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		NumMatricula = numMatricula;
	}

}
