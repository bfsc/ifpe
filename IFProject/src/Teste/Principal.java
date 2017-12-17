package Teste;

import java.sql.Connection;
import com.IF.JDBC.cnxjdbc;

public class Principal {

	public static void main(String[] args) {
		
		Connection c = cnxjdbc.Conection();
		
		if(c == null) {
			System.out.println("Não conectou!!!");
		} else {
			System.out.println("Conectado");
		}
	}
}
