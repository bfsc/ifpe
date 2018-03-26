package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.IF.Main;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorDisciplinaJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ControladorDisciplinaJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblControladorDisciplina = new JLabel("Controlador de Disciplinas");
		lblControladorDisciplina.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblControladorDisciplina.setBounds(260, 54, 272, 29);
		add(lblControladorDisciplina);
		
		JButton btnCadastrarDisciplinas = new JButton("Cadastrar");
		btnCadastrarDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new CadastrarDisciplinaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnCadastrarDisciplinas.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrarDisciplinas.setBounds(337, 168, 120, 30);
		add(btnCadastrarDisciplinas);
		
		JButton btnChamada = new JButton("Chamada");
		btnChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new DisciplinaJPanel());
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
