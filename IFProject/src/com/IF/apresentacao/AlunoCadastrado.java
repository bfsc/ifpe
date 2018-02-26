package com.IF.apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AlunoCadastrado extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlunoCadastrado dialog = new AlunoCadastrado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlunoCadastrado() {
		setBounds(100, 100, 446, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAlunoCadastrado = new JLabel("Aluno cadastrado com sucesso!!");
		lblAlunoCadastrado.setForeground(new Color(0, 0, 0));
		lblAlunoCadastrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunoCadastrado.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblAlunoCadastrado.setBounds(28, 88, 372, 14);
		contentPanel.add(lblAlunoCadastrado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		
	}
}
