package com.IF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.IF.JDBC.cnxjdbc;
import com.IF.entidades.Turma;

public class TurmaDAO {
	
	private final static String TURMA_COLUNA_NOME = "nome";
	
	private final String SQL_INSERE_TURMA = "INSERT INTO tbl_turma(nome) values (?)";
	private final String SQL_ALTERA_TURMA = "UPDATE USUARIOS SET Nome=?";
	private final String SQL_EXCLUI_TURMA = "DELETE FROM tbl_turma WHERE Nome=?";
	private final String SQL_SELECIONA_TURMA = "SELECT * FROM tbl_turma";

	private PreparedStatement pst = null;
	
	//ATRIBUTOS ESTATICOS
	private static TurmaDAO instancia;
	
	private ArrayList<Turma> listaDeTurma;
	
	//CONSTRUTORES 
	
	private TurmaDAO() {
		this.listaDeTurma = new ArrayList<Turma>();
	}
	
	//METODOS ESTATICOS
	
	public static TurmaDAO getInstancia() {
		
		if(instancia == null) {
		   instancia = new TurmaDAO();
		}
		
		return instancia;
	}
	
	//METODOS PUBLICOS
	
	public boolean adicionarTurma(Turma turma) {
		
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_INSERE_TURMA);
			pst.setString(1, turma.getNomeTurma());
			pst.execute();
			pst.close();
			
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		} finally {
			cnxjdbc.fecharCNX();
		}
	}
	
	public Set<Turma> ListarTurmas() {
		
		Turma turma;
		Set<Turma> retTurma = new HashSet<Turma>();
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_SELECIONA_TURMA);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				turma = new Turma();
				turma.setNome(rs.getString(TURMA_COLUNA_NOME));
				retTurma.add(turma);
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statement(ListandoTurmas)" + e.toString());
		}
		
		return retTurma;
	}
	
	public boolean alterarTurma(Turma turma) {
		
		boolean ret = false;
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_ALTERA_TURMA);
			pst.setString(1, turma.getNomeTurma());
			ret = pst.execute();
			pst.close();
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statement(AlterrarTurmas)" + e.toString());
		}
		
		return ret;
		
	}
	
	public boolean deletarTurma(Turma turma) {
		
		boolean ret = false;
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_EXCLUI_TURMA);
			pst.setString(1, turma.getNomeTurma());
			ret = pst.execute();
			pst.close();
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statement(deletarTurmas)" + e.toString());
		}
		
		return ret;
	}
}
