import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.IF.JDBC.cnxjdbc;
import com.IF.dao.AlunoDAO;
import com.IF.entidades.Aluno;

public class GTEST {

	private static final String SQL_INSERE_ALUNO = "INSERT INTO Aluno (nome, matricula) values ('TESTE','TESTE')";
	 //private static final String SQL_INSERE_ALUNO = "INSERT INTO Aluno (nome, matricula) values(?,?)";
	//private static final String SQL_CREATE_TABLE_ALUNO = "CREATE TABLE aluno(nome varchar(100),matricula varchar(10))";
	
	private final static String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private static String usuario = "SA";
	private static String senha = "";
	private static String PathBase = System.getProperty("user.home") + "\\.if";
	private final static String URL = "jdbc:hsqldb:hsql://localhost/if;shutdown=true;hsqldb.write_delay=false";
	
	public static void main(String[] args) {
		try {

				
				
				Class.forName(DRIVER_CLASS);
				Connection conn = DriverManager.getConnection(URL, usuario, senha);
				conn.setAutoCommit(true);
				
				PreparedStatement pst = conn.prepareStatement(SQL_INSERE_ALUNO);
				
				//pst.setString(1, "BLA");
				//pst.setString(2, "BLE");
				
				pst.execute();
				
				ResultSet resultSet = conn.prepareStatement("SELECT * FROM ALUNO").executeQuery();
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1));
				}
				
				pst.close();
				

			} catch (Throwable t) {
				t.printStackTrace();
			}
		
	}
	
}
