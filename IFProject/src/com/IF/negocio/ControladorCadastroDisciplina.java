package com.IF.negocio;

import java.util.ArrayList;
import java.util.Set;

import org.hsqldb.lib.HashSet;

import com.IF.dao.DisciplinaDAO;
import com.IF.entidades.Disciplina;
import com.IF.excecoes.DisciplinaInvalidaException;

public class ControladorCadastroDisciplina {

	//Metodos públicos
	
	public void CadastrarDisciplina (Disciplina disciplina) throws DisciplinaInvalidaException{
		//Valida cada um dos atributos da Disciplina
		DisciplinaInvalidaException disciplinaInvalidoException = validarDisciplina(disciplina);
		
		if(disciplinaInvalidoException != null) {
			// Levantar excecao caso os dados da Disciplina nao tenham passado na validacao
			throw disciplinaInvalidoException;
		} else {
			DisciplinaDAO.getInstancia().adicionarDisciplina(disciplina);
		}
		
	}
	
	public ArrayList<Disciplina> BuscarDisciplinaPorNome(String nomeDisciplina){
		ArrayList<Disciplina> DisciplinasEncontradas = new ArrayList<Disciplina>();
		
		Set<Disciplina> listaDeDisciplinas = DisciplinaDAO.getInstancia().ListarDisciplina();
		for (Disciplina disciplina : listaDeDisciplinas) {
			if(disciplina.getNomeDisciplina().toUpperCase().contains(nomeDisciplina.toUpperCase())) {
				DisciplinasEncontradas.add(disciplina);
			}
		}
		
		return DisciplinasEncontradas;
	}
	
	public Set<Disciplina> obterTodasAsDisciplinas(){
		return DisciplinaDAO.getInstancia().ListarDisciplina();
	}
	
	public void AtualizarDisciplinas(Disciplina disciplina) throws DisciplinaInvalidaException {
		
		DisciplinaInvalidaException disciplinaInvalidaException = validarDisciplina(disciplina);
		
		if(disciplinaInvalidaException != null) {
			
			throw disciplinaInvalidaException;
		} else {
			DisciplinaDAO.getInstancia().alterarDisciplina(disciplina);
		}
		
	}
	
	public void deletarDisciplina(Disciplina disciplina) {
		DisciplinaDAO.getInstancia().deletarDisciplina(disciplina);
	}
	
	//Metodos privados
	
	private DisciplinaInvalidaException validarDisciplina(Disciplina disciplina) {
		DisciplinaInvalidaException disciplinaInvalidaException = null;
		
		if(disciplina.getNomeDisciplina() == null || disciplina.getNomeDisciplina().trim().isEmpty()) {
			if(disciplinaInvalidaException == null) {
				disciplinaInvalidaException = new DisciplinaInvalidaException();
			}
			disciplinaInvalidaException.setNomeDisciplinaVazio(true);
		}
		
		return disciplinaInvalidaException;
	}
	
}