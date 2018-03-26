package com.IF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.IF.JDBC.cnxjdbc;
import com.IF.entidades.Aluno;
import com.IF.entidades.Disciplina;

public class AlunoDAO {
	
	//Constantes.
	private final static String ALUNO_COLUNA_NOME = "nome";
	private final static String ALUNO_COLUNA_MATRICULA = "matricula";
	
	//Comandos SQL em composições.
	private final String SQL_INSERE_ALUNO = "INSERT INTO tbl_aluno (nome, matricula) values (?,?)";
	private final String SQL_ALTERA_ALUNO = "UPDATE aluno SET Nome=?, NumMatricula=?";
	private final String SQL_EXCLUI_ALUNO = "DELETE FROM tbl_aluno WHERE Nome=?";
	private final String SQL_SELECIONA_TODOS_ALUNOS = "SELECT * FROM tbl_aluno";
	private final String SQL_SELECIONA_ALUNO = "select * from tbl_aluno (nome) values (?)";
	
	private PreparedStatement pst = null;
	
	// ATRIBUTOS ESTATICOS
	private static AlunoDAO instancia;
	
	/**
	 * Conjunto de pacientes que armazena todos os alunos cadastrados no sistema.
	 */
	
	private ArrayList<Aluno> listaDeAlunos;
	
	//CONSTRUTORES
	
	private AlunoDAO() {
		this.listaDeAlunos = new ArrayList<Aluno>();
	}
	
	// METODOS ESTATICOS
	
	public static AlunoDAO getInstancia() {

		if (instancia == null) {
			instancia = new AlunoDAO();
		}
			
		return instancia;
	}
	
	//METODOS PUBLICOS
	
	public boolean adicionarAluno(Aluno aluno) {
				
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_INSERE_ALUNO);
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getNumMatricula());
			pst.execute();
			pst.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
			System.out.println("Erro ao executar o Statment(Adicionando Aluno)" + e.toString());
			
			return false;
		} finally {
			cnxjdbc.fecharCNX();
		}
		
	}
	
	public Set<Aluno> listarTodosAlunos(){
		
		Aluno aluno;
		Set<Aluno> retAluno = new HashSet<Aluno>();
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_SELECIONA_TODOS_ALUNOS);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString(ALUNO_COLUNA_NOME));
				aluno.setNumMatricula(rs.getString(ALUNO_COLUNA_MATRICULA));
				retAluno.add(aluno);
			}
			
			rs.close();
			pst.close();
			
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement(Listando Aluno)" + e.toString());
		}
		return retAluno;
	}
	
	public boolean alterarAluno(Aluno aluno) {
		
		boolean ret = false;
		Connection conn = cnxjdbc.Conection();
		
		try {
			pst = conn.prepareStatement(SQL_ALTERA_ALUNO);
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getNumMatricula());
			ret = pst.execute();
			pst.close();
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statment(Alterando aluno)" + e.toString());
		}
		return ret;
	}
	
	public boolean deletarAluno(Aluno aluno) {
		
		boolean ret = false;
		Connection conn = cnxjdbc.Conection();
	
		try {
			
			pst = conn.prepareStatement(SQL_EXCLUI_ALUNO);
			pst.setString(1,  aluno.getNome());
			ret = pst.execute();
			pst.close();
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statment(Excluindo Aluno)" + e.toString());
		}
		
		return ret;
	}
}
