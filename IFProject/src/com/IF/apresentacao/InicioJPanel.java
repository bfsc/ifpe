package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.IF.Main;
import com.IF.apresentacao.AcessoJPanel;

public class InicioJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InicioJPanel() {
		setLayout(null);
		setSize(800,600);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getFrame().setContentPane(new AcessoJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		
		btnIniciar.setForeground(new Color(255, 0, 0));
		btnIniciar.setBackground(new Color(34, 139, 34));
		btnIniciar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnIniciar.setBounds(337, 391, 120, 40);
		add(btnIniciar);

	}
}
