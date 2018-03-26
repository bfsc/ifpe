package com.IF.excecoes;

public class DisciplinaInvalidaException extends Exception{
	
	private boolean NomeDisciplinaVazio;
	
	public DisciplinaInvalidaException() {
		
	}
	
	public boolean isNomeDisciplinaVazio() {
		return NomeDisciplinaVazio;
	}
	
	public void setNomeDisciplinaVazio(boolean NomeDisciplinaVazio) {
		this.NomeDisciplinaVazio = NomeDisciplinaVazio;
	}

}
