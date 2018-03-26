package com.IF.negocio;

import java.util.ArrayList;
import java.util.Set;

import org.hsqldb.lib.HashSet;

import com.IF.dao.AlunoDAO;
import com.IF.entidades.Aluno;
import com.IF.excecoes.AlunoInvalidoException;

public class ControladorCadastroAluno {
	
	// Metodos publicos
	
	public void cadastrarAluno (Aluno aluno) throws AlunoInvalidoException{
		// Valida cada um dos atributos do aluno
		AlunoInvalidoException alunoInvalidoException = validarAluno(aluno);
		
		if(alunoInvalidoException != null) {
			// Levantar excecao caso os dados do aluno nao tenham passado na validacao
			throw alunoInvalidoException;
		} else {
			// Cadastrar o aluno caso os dados tenham passado na validacao
			AlunoDAO.getInstancia().adicionarAluno(aluno);
		}
		
	}
	
	public ArrayList<Aluno> buscarAlunoPorNome(String nome){
		ArrayList<Aluno> alunosEncontrados =  new ArrayList<Aluno>();
		
		Set<Aluno> listaDeAlunos = AlunoDAO.getInstancia().listarTodosAlunos();
		for (Aluno aluno : listaDeAlunos) {
			if(aluno.getNome().toUpperCase().contains(nome.toUpperCase())) {
				alunosEncontrados.add(aluno);
			}
		}
		
		return alunosEncontrados;
	}
	
	public Set<Aluno> obterTodosAlunos(){
		return  AlunoDAO.getInstancia().listarTodosAlunos();
	}
	
	public void atualizarAluno(Aluno aluno) throws AlunoInvalidoException{
		// Valida cada um dos atributos do aluno
		AlunoInvalidoException alunoInvalidoException = validarAluno(aluno);
		
		if(alunoInvalidoException != null) {
			// Levantar excecao caso os dados do aluno nao tenham passado na validacao
			throw alunoInvalidoException;
		} else {
			// Atualiza o aluno caso os dados tenham passado na validacao
			AlunoDAO.getInstancia().alterarAluno(aluno);
		}
	}
	
	public void deletarAluno(Aluno aluno) {
		AlunoDAO.getInstancia().deletarAluno(aluno);
	}
	
	public void selecionarAluno(Aluno aluno) throws AlunoInvalidoException {
		
		
		
	}
	
	//Metodos Privados
	
	private AlunoInvalidoException validarAluno(Aluno aluno) {
		AlunoInvalidoException alunoInvalidoException = null;
		
		if(aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
			if(alunoInvalidoException == null) {
				alunoInvalidoException = new AlunoInvalidoException();
			}
			alunoInvalidoException.setNomeVazio(true);
		}
		
		//if(aluno.getNumMatricula() == null || aluno.getNumMatricula().trim().isEmpty()) {
		//	if(alunoInvalidoException == null) {
		//		alunoInvalidoException = new AlunoInvalidoException();
		//	}
		//	alunoInvalidoException.setnumMatriculaVazio(true);
		//}
		
		return alunoInvalidoException;
	}
	
}