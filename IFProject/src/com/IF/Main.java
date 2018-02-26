package com.IF;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JButton;

import com.IF.JDBC.cnxjdbc;
import com.IF.apresentacao.InicioJPanel;


public class Main {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initDB();
					
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setContentPane(new InicioJPanel());
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	private static void initDB() {
		File diretorio = new File(cnxjdbc.DB_FOLDER_PATH);
		
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
        
		try {
			Process exec = Runtime.getRuntime().exec("java -cp ./lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:" + cnxjdbc.DB_FOLDER_PATH  +  "\\if --dbname.0 if");
			
			BufferedReader os = new BufferedReader(new InputStreamReader(exec.getInputStream()));
			BufferedReader es = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
			
			String line = "";
			while((line = os.readLine()) != null) {
				System.out.println(line);
			}
			
			while((line = es.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Throwable t) {
			throw new RuntimeException("ERRO AO LEVANTAR O BANCO DE DADOS", t);
		}
		
        
	}
}
