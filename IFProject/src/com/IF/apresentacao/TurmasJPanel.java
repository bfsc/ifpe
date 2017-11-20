package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import com.IF.Main;
import com.IF.apresentacao.ControladorTurmaJPanel;
import com.IF.apresentacao.ChamadaJPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TurmasJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TurmasJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblTurmas = new JLabel("Turmas");
		lblTurmas.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTurmas.setBounds(357, 47, 108, 29);
		add(lblTurmas);
		
		JList listListaMateria = new JList();
		listListaMateria.setBounds(202, 119, 401, 159);
		add(listListaMateria);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new ControladorTurmaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnVoltar.setBounds(54, 520, 120, 30);
		add(btnVoltar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new CadastrarTurmaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnAtualizar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnAtualizar.setBounds(345, 327, 120, 30);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnDeletar.setBounds(345, 383, 120, 30);
		add(btnDeletar);
		
		JButton btnChamada = new JButton("Chamada");
		btnChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new ChamadaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnChamada.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnChamada.setBounds(650, 520, 120, 30);
		add(btnChamada);
		
	}

}
