package com.IF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.IF.JDBC.cnxjdbc;
import com.IF.entidades.Disciplina;

public class DisciplinaDAO {
	
	private final static String DISCIPLINA_COLUNA_NOME = "nome";
	
	private final String SQL_INSERE_DISCIPLINA = "INSERT INTO tbl_disciplina(nome) values (?)";
	private final String SQL_ALTERA_DISCIPLINA = "UPDATE disciplina SET Nome=?";
	private final String SQL_EXCLUI_DISCIPLINA = "DELETE FROM tbl_disciplina WHERE Nome=?";
	private final String SQL_SELECIONA_DISCIPLINA = "SELECT * FROM tbl_disciplina";

	private PreparedStatement pst = null;
	
	//ATRIBUTOS ESTATICOS
	private static DisciplinaDAO instancia;
	
	private ArrayList<Disciplina> listaDeDisciplina;
	
	//CONSTRUTORES 
	
	private DisciplinaDAO() {
		this.listaDeDisciplina = new ArrayList<Disciplina>();
	}
	
	//METODOS ESTATICOS
	
	public static DisciplinaDAO getInstancia() {
		
		if(instancia == null) {
		   instancia = new DisciplinaDAO();
		}
		
		return instancia;
	}
	
	//METODOS PUBLICOS
	
	public boolean adicionarDisciplina(Disciplina disciplina) {
		
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_INSERE_DISCIPLINA);
			pst.setString(1, disciplina.getNomeDisciplina());
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
	
	public Set<Disciplina> ListarDisciplina() {
		
		Disciplina disciplina;
		Set<Disciplina> retDisciplina = new HashSet<Disciplina>();
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_SELECIONA_DISCIPLINA);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				disciplina = new Disciplina();
				disciplina.setNome(rs.getString(DISCIPLINA_COLUNA_NOME));
				retDisciplina.add(disciplina);
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statement(ListandoDisciplina)" + e.toString());
		}
		
		return retDisciplina;
	}
	
	public boolean alterarDisciplina(Disciplina disciplina) {
		
		boolean ret = false;
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_ALTERA_DISCIPLINA);
			pst.setString(1, disciplina.getNomeDisciplina());
			ret = pst.execute();
			pst.close();
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statement(AlterrarDisciplina)" + e.toString());
		}
		
		return ret;
		
	}
	
	public boolean deletarDisciplina(Disciplina disciplina) {
		
		boolean ret = false;
		Connection conn = cnxjdbc.Conection();
		
		try {
			
			pst = conn.prepareStatement(SQL_EXCLUI_DISCIPLINA);
			pst.setString(1, disciplina.getNomeDisciplina());
			ret = pst.execute();
			pst.close();
			cnxjdbc.fecharCNX();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statement(deletarDisciplina)" + e.toString());
		}
		
		return ret;
	}
}
