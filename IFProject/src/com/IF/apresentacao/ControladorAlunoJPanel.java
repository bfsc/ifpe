package com.IF.apresentacao;

import javax.swing.JPanel;

import com.IF.Main;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorAlunoJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ControladorAlunoJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new CadastrarAlunoJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnCadastrarAluno.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrarAluno.setBounds(337, 168, 120, 30);
		add(btnCadastrarAluno);
		
		JButton btnAtualizarAluno = new JButton("Atualizar");
		btnAtualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new CadastrarAlunoJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnAtualizarAluno.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnAtualizarAluno.setBounds(337, 265, 120, 30);
		add(btnAtualizarAluno);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new AcessoJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnVoltar.setBounds(35, 520, 120, 30);
		add(btnVoltar);
		
		JLabel lblControladorDeAlunos = new JLabel("Controlador de Alunos");
		lblControladorDeAlunos.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblControladorDeAlunos.setBounds(271, 52, 272, 29);
		add(lblControladorDeAlunos);

	}
}
