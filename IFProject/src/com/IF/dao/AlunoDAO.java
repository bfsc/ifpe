package com.IF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.IF.JDBC.cnxjdbc;
import com.IF.entidades.Aluno;

public class AlunoDAO {
	
	//private final String SQL_INSERE_ALUNO = "INSERT INTO \"PUBLIC\".\"ALUNO\"(\"Nome\", \"NumMatricula\" ) VALUES ( ?, ?)" ;
	private final String SQL_INSERE_ALUNO = "INSERT INTO Aluno" + "(Nome, NumMatricula)" + "values(?,?)";
	private final String SQL_ALTERA_ALUNO = "UPDATE USUARIOS SET Nome=?, NumMatricula=?";
	private final String SQL_EXCLUI_ALUNO = "DELETE FROM ALUNOS WHERE Nome=?";
	private final String SQL_SELECIONA_ALUNO = "SELECT * FROM ALUNOS";
	
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
			listaDeAlunos.add(aluno);
			pst.execute();
			pst.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statment(Adicionando Aluno)" + e.toString());
			return false;
		} finally {
			cnxjdbc.fecharCNX();
		}
		
	}
	
	public ArrayList<Aluno> listarTodosAlunos(){
		
		Connection conn = cnxjdbc.Conection();
		Aluno aluno;
		
		try {
			pst = conn.prepareStatement(SQL_SELECIONA_ALUNO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString("NOME"));
				aluno.setNumMatricula(rs.getString("NumMatricula"));
				listaDeAlunos.add(aluno);
			}
			rs.close();
			pst.close();
			cnxjdbc.fecharCNX();
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement(Listando Aluno)" + e.toString());
		}
		return listaDeAlunos;
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
			System.out.println("Erro ao executar o Statment(Excluindo Aluno)" + e.toString());
		}
		return ret;
}
	
}
