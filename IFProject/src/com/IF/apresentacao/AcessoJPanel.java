package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.IF.Main;
import com.IF.apresentacao.InicioJPanel;
import com.IF.apresentacao.ControladorAlunoJPanel;
import com.IF.apresentacao.ControladorDisciplinaJPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AcessoJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AcessoJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new ControladorDisciplinaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnDisciplina.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnDisciplina.setBounds(221, 310, 120, 30);
		add(btnDisciplina);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new ControladorAlunoJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnAluno.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAluno.setBounds(440, 310, 120, 30);
		add(btnAluno);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getFrame().setContentPane(new InicioJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnVoltar.setBounds(35, 520, 120, 30);
		add(btnVoltar);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblMenu.setBounds(358, 52, 75, 29);
		add(lblMenu);

	}

}
