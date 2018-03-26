package com.IF.entidades;

public class Aluno {
	
	// Atributos
	
	private boolean id;
	private String nome;
	private String numMatricula;
	private Disciplina disciplina;
	
	// Construtores
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, boolean id, String numMatricula, Disciplina disciplina) {
		this.nome = nome;
		this.id = id;
		this.numMatricula = numMatricula;
	}
	
	// Metodos Públicos
	
	public String toString() {
		return this.nome;
	}
	
	// Get and Set

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public boolean isID() {
		return id;
	}

	public void setID(boolean id) {
		this.id = id;
	}

	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

}
