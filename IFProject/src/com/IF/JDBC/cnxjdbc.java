package com.IF.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cnxjdbc {
	
	private final static String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private static Connection conn = null;
	private static String usuario = "sa";
	private static String senha = "";
	public final static String DB_FOLDER_PATH = System.getProperty("user.home") + "\\.ifdb";
	private final static String URL = "jdbc:hsqldb:hsql://localhost/if;shutdown=true;hsqldb.write_delay=false";
	
	public static Connection Conection() {
		
		if(conn == null) {
			
			try {
				Class.forName(DRIVER_CLASS);
				// Estabelecendo uma conexão
				conn = DriverManager.getConnection(URL, usuario, senha);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void fecharCNX() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}