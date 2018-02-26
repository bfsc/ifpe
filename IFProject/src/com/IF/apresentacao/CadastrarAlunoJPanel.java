package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

import com.IF.Main;
import com.IF.entidades.Aluno;
import com.IF.excecoes.AlunoInvalidoException;
import com.IF.negocio.ControladorCadastroAluno;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarAlunoJPanel extends JPanel {
	private JTextField textNomeAluno;
	private JTextField textNumMatricula;
	
	/**
	 * Create the panel.
	 */
	public CadastrarAlunoJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblCadastroAluno = new JLabel("Cadastro de Aluno");
		lblCadastroAluno.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCadastroAluno.setBounds(296, 53, 233, 29);
		add(lblCadastroAluno);
		
		JLabel lblNomeAluno = new JLabel("Nome*");
		lblNomeAluno.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNomeAluno.setBounds(101, 191, 57, 14);
		add(lblNomeAluno);
		
		textNomeAluno = new JTextField();
		textNomeAluno.setBounds(101, 216, 253, 20);
		add(textNomeAluno);
		textNomeAluno.setColumns(10);
		
		JLabel lblNmeroDeMatricula = new JLabel("N\u00FAmero de matricula");
		lblNmeroDeMatricula.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNmeroDeMatricula.setBounds(101, 247, 185, 14);
		add(lblNmeroDeMatricula);

		
		textNumMatricula = new JTextField();
		textNumMatricula.setColumns(10);
		textNumMatricula.setBounds(101, 272, 253, 20);
		add(textNumMatricula);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Criando o objeto aluno.
				Aluno aluno = new Aluno();
				
				//Pegando os atributos inseridos nos campos e setando aos atributos do objeto.
				aluno.setNome(textNomeAluno.getText());
				aluno.setNumMatricula(textNumMatricula.getText());
				
				//Jogando o objeto ao controlador para testar a validação.
				try {
					
					ControladorCadastroAluno ControladorCadastro = new ControladorCadastroAluno();
					ControladorCadastro.cadastrarAluno(aluno);
					
					//Chamando o dialog caso o aluno seja cadastrado.
					AlunoCadastrado dialogAlunoCadastrado = new AlunoCadastrado();
					dialogAlunoCadastrado.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogAlunoCadastrado.setLocationRelativeTo(null);
					dialogAlunoCadastrado.setVisible(true);
					
				} catch (AlunoInvalidoException excecao) {
					
					//Chamando o dialog caso o nome do aluno seja vazio.
					if (excecao.isNomeVazio()) {
						
						NomeAlunoVazio dialogNomeVazio = new NomeAlunoVazio();
						dialogNomeVazio.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialogNomeVazio.setLocationRelativeTo(null);
						dialogNomeVazio.setVisible(true);
			
					} 
					
				} 
				
				//Limpando o campo de texto da tela.
				textNomeAluno.setText("");
				textNumMatricula.setText("");
				
			}
		});
		btnCadastrar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrar.setBounds(658, 520, 120, 30);
		add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Limpando o campo de texto da tela.
				textNomeAluno.setText("");
				textNumMatricula.setText("");
			}
		});
		btnLimpar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnLimpar.setBounds(336, 520, 120, 30);
		add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new ControladorAlunoJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnVoltar.setBounds(35, 520, 120, 30);
		add(btnVoltar);
		
		JLabel lblDigital = new JLabel("Coloque o dedo indicador!!");
		lblDigital.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblDigital.setBounds(560, 242, 230, 14);
		add(lblDigital);
		lblDigital.setVisible(false);
		
		JLabel lblOk = new JLabel("Ok!");
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblOk.setBounds(647, 242, 57, 14);
		add(lblOk);
		lblOk.setVisible(false);
		
		JButton btnCadastrarDigital = new JButton("Digital");
		btnCadastrarDigital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblDigital.setVisible(true);
			}
		});
		btnCadastrarDigital.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrarDigital.setBounds(437, 234, 100, 30);
		add(btnCadastrarDigital);

	}
}
