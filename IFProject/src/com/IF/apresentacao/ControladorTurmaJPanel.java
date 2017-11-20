package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.IF.Main;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorTurmaJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ControladorTurmaJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblControladorTurma = new JLabel("Controlador de Turmas");
		lblControladorTurma.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblControladorTurma.setBounds(260, 54, 272, 29);
		add(lblControladorTurma);
		
		JButton btnCadastrarTurmas = new JButton("Cadastrar");
		btnCadastrarTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new CadastrarTurmaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnCadastrarTurmas.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrarTurmas.setBounds(337, 168, 120, 30);
		add(btnCadastrarTurmas);
		
		JButton btnChamada = new JButton("Chamada");
		btnChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new TurmasJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnChamada.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnChamada.setBounds(337, 265, 120, 30);
		add(btnChamada);
		
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

	}

}
