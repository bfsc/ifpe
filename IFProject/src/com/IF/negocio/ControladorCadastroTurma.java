package com.IF.negocio;

import java.util.ArrayList;
import java.util.Set;

import org.hsqldb.lib.HashSet;

import com.IF.dao.TurmaDAO;
import com.IF.entidades.Turma;
import com.IF.excecoes.TurmaInvalidaException;

public class ControladorCadastroTurma {

	//Metodos públicos
	
	public void CadastrarTurma (Turma turma) throws TurmaInvalidaException{
		//Valida cada um dos atributos da turma
		TurmaInvalidaException turmaInvalidoException = validarTurma(turma);
		
		if(turmaInvalidoException != null) {
			// Levantar excecao caso os dados da turma nao tenham passado na validacao
			throw turmaInvalidoException;
		} else {
			TurmaDAO.getInstancia().adicionarTurma(turma);
		}
		
	}
	
	public ArrayList<Turma> BuscarTurmaPorNome(String nomeTurma){
		ArrayList<Turma> turmasEncontradas = new ArrayList<Turma>();
		
		Set<Turma> listaDeTurmas = TurmaDAO.getInstancia().ListarTurmas();
		for (Turma turma : listaDeTurmas) {
			if(turma.getNomeTurma().toUpperCase().contains(nomeTurma.toUpperCase())) {
				turmasEncontradas.add(turma);
			}
		}
		
		return turmasEncontradas;
	}
	
	public Set<Turma> obterTodasAsTurmas(){
		return TurmaDAO.getInstancia().ListarTurmas();
	}
	
	public void AtualizarTurmas(Turma turma) throws TurmaInvalidaException {
		
		TurmaInvalidaException turmaInvalidaException = validarTurma(turma);
		
		if(turmaInvalidaException != null) {
			
			throw turmaInvalidaException;
		} else {
			TurmaDAO.getInstancia().alterarTurma(turma);
		}
		
	}
	
	public void deletarAluno(Turma turma) {
		TurmaDAO.getInstancia().deletarTurma(turma);
	}
	
	//Metodos privados
	
	private TurmaInvalidaException validarTurma(Turma turma) {
		TurmaInvalidaException turmaInvalidaException = null;
		
		if(turma.getNomeTurma() == null || turma.getNomeTurma().trim().isEmpty()) {
			if(turmaInvalidaException == null) {
				turmaInvalidaException = new TurmaInvalidaException();
			}
			turmaInvalidaException.setNomeTurmaVazio(true);
		}
		
		return turmaInvalidaException;
	}
	
}