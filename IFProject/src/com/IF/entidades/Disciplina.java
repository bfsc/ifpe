package com.IF.entidades;

public class Disciplina {
	
	private int idDisciplina;
	private String nomeDisciplina;
	
	// Construtor padrao sem parametros em situacoes que seja necessario criar um objeto Disciplina sem definir os valores iniciais dos atributos.
	
	public Disciplina() {
		
	}
	
	// Construtor que recebe parametros para iniciar todos os atributos de um objeto Disciplina.


	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	// Metodos públicos
	
	public String toString() {
		return this.nomeDisciplina;
	}
	
	// Getter and setters

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNome(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public int getId() {
		return idDisciplina;
	}

	public void setId(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
}
