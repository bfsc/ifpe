package com.IF.entidades;

public class Turma {
	
	private String nome;
	private Aluno aluno;
	
	// Construtor padrao sem parametros em situacoes que seja necessario criar um objeto Endereco sem definir os valores iniciais dos atributos.
	
	public Turma() {
		
	}
	
	// Construtor que recebe parametros para iniciar todos os atributos de um objeto Endereco.
	
	public Turma(Aluno aluno, String nome) {
		this.aluno = aluno;
		this.nome = nome;
	}
	
	// Metodos públicos
	
	public String toString() {
		return this.nome;
	}
	
	// Getter and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
