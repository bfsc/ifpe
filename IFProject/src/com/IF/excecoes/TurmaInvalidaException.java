package com.IF.excecoes;

public class TurmaInvalidaException extends Exception{
	
	private boolean NomeTurmaVazio;
	
	public TurmaInvalidaException() {
		
	}
	
	public boolean isNomeTurmaVazio() {
		return NomeTurmaVazio;
	}
	
	public void setNomeTurmaVazio(boolean NomeTurmaVazio) {
		this.NomeTurmaVazio = NomeTurmaVazio;
	}

}
