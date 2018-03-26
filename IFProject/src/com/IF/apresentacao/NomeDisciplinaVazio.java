package com.IF.apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class NomeDisciplinaVazio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NomeDisciplinaVazio dialog = new NomeDisciplinaVazio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NomeDisciplinaVazio() {
		setBounds(100, 100, 446, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblONomeDa = new JLabel("O nome da disciplina est\u00E1 vazia!!");
			lblONomeDa.setHorizontalAlignment(SwingConstants.CENTER);
			lblONomeDa.setForeground(Color.BLACK);
			lblONomeDa.setFont(new Font("Arial Black", Font.BOLD, 18));
			lblONomeDa.setBounds(10, 71, 410, 14);
			contentPanel.add(lblONomeDa);
		}
		
		JButton button = new JButton("OK!!");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(165, 136, 109, 35);
		contentPanel.add(button);
	}

}
