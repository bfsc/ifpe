package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.IF.entidades.Aluno;
import com.IF.negocio.ControladorCadastroAluno;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Set;

public class AtualizarAlunoJPanel extends JPanel {
	private JTextField textFieldNomeAtt;

	/**
	 * Create the panel.
	 */
	public AtualizarAlunoJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JList listAluno = new JList();
		listAluno.setBounds(87, 107, 246, 377);
		add(listAluno);
		
		ControladorCadastroAluno controladorCadastroAluno = new ControladorCadastroAluno();
		ArrayList<Aluno> aluno = controladorCadastroAluno.obterTodosAlunos();
		listAluno.setListData(aluno.toArray());
		
		JLabel lblAtt = new JLabel("Atualizar / Deletar Aluno");
		lblAtt.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblAtt.setBounds(296, 53, 319, 29);
		add(lblAtt);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNome.setBounds(399, 123, 60, 29);
		add(lblNome);
		
		textFieldNomeAtt = new JTextField();
		textFieldNomeAtt.setBounds(399, 152, 304, 29);
		add(textFieldNomeAtt);
		textFieldNomeAtt.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAtualizar.setBounds(495, 268, 120, 30);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnDeletar.setBounds(495, 340, 120, 30);
		add(btnDeletar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnVoltar.setBounds(35, 520, 120, 30);
		add(btnVoltar);

	}
}
