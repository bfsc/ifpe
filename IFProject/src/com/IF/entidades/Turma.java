package com.IF.entidades;

public class Turma {
	
	private long id;
	private String NomeTurma;
	
	// Construtor padrao sem parametros em situacoes que seja necessario criar um objeto Endereco sem definir os valores iniciais dos atributos.
	
	public Turma() {
		
	}
	
	// Construtor que recebe parametros para iniciar todos os atributos de um objeto Endereco.


	public Turma(String NomeTurma) {
		this.NomeTurma = NomeTurma;
	}
	
	// Metodos públicos
	
	public String toString() {
		return this.NomeTurma;
	}
	
	// Getter and setters

	public String getNomeTurma() {
		return NomeTurma;
	}

	public void setNome(String NomeTurma) {
		this.NomeTurma = NomeTurma;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
