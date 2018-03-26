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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisciplinaCadastrada extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DisciplinaCadastrada dialog = new DisciplinaCadastrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DisciplinaCadastrada() {
		setBounds(100, 100, 446, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDisciplinaCadastradoCom = new JLabel("Disciplina cadastrada com sucesso!!");
		lblDisciplinaCadastradoCom.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisciplinaCadastradoCom.setForeground(Color.BLACK);
		lblDisciplinaCadastradoCom.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblDisciplinaCadastradoCom.setBounds(10, 71, 410, 14);
		contentPanel.add(lblDisciplinaCadastradoCom);
		
		JButton btnOk = new JButton("OK!!");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnOk.setBounds(165, 136, 109, 35);
		contentPanel.add(btnOk);
	}
}
