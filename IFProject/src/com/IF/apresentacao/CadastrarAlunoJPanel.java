package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.IF.Main;

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
		btnCadastrar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrar.setBounds(658, 520, 120, 30);
		add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
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
		
		JButton btnCadastrarDigital = new JButton("Digital");
		btnCadastrarDigital.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrarDigital.setBounds(437, 234, 100, 30);
		add(btnCadastrarDigital);
		
		JLabel lblDigital = new JLabel("Coloque o dedo indicador");
		lblDigital.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblDigital.setBounds(567, 247, 208, 14);
		add(lblDigital);
		
		JLabel lblOk = new JLabel("Ok!");
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblOk.setBounds(646, 275, 57, 14);
		add(lblOk);

	}
}
