package com.IF.excecoes;

public class AlunoInvalidoException extends Exception{
	
	private boolean nomeVazio;
	private boolean numMatriculaVazio;
	
	
	public AlunoInvalidoException() {
		
	}
	
	public boolean isNomeVazio() {
		return nomeVazio;
	}
	
	public void setNomeVazio(boolean nomeVazio) {
		this.nomeVazio = nomeVazio;
	}
	
	public boolean isnumMatriculaVazio() {
		return numMatriculaVazio;
	}
	
	public void setnumMatriculaVazio(boolean numMatriculaVazio) {
		this.numMatriculaVazio = numMatriculaVazio;
	}

}
