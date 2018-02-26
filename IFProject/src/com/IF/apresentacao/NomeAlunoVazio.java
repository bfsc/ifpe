package com.IF.apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class NomeAlunoVazio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NomeAlunoVazio dialog = new NomeAlunoVazio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NomeAlunoVazio() {
		setBounds(100, 100, 446, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblONomeVazio = new JLabel("O Nome do aluno est\u00E1 vazio!!");
		lblONomeVazio.setHorizontalAlignment(SwingConstants.CENTER);
		lblONomeVazio.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblONomeVazio.setBounds(28, 88, 372, 14);
		contentPanel.add(lblONomeVazio);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
