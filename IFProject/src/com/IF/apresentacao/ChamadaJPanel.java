package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

import com.IF.Main;
import com.IF.apresentacao.DisciplinaJPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChamadaJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ChamadaJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblAlunosDaDisciplina = new JLabel("Lista de Alunos da Disciplina");
		lblAlunosDaDisciplina.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblAlunosDaDisciplina.setBounds(103, 122, 185, 14);
		add(lblAlunosDaDisciplina);
		
		JList listAlunosDaDisciplina = new JList();
		listAlunosDaDisciplina.setBounds(79, 147, 226, 349);
		add(listAlunosDaDisciplina);
		
		JLabel lblAlunosPresente = new JLabel("Lista de Alunos presentes");
		lblAlunosPresente.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblAlunosPresente.setBounds(344, 122, 185, 14);
		add(lblAlunosPresente);
		
		JList listAlunosPresente = new JList();
		listAlunosPresente.setBounds(321, 147, 226, 349);
		add(listAlunosPresente);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new DisciplinaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		button.setFont(new Font("Arial Black", Font.BOLD, 13));
		button.setBounds(35, 520, 120, 30);
		add(button);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnUpload.setBounds(654, 520, 120, 30);
		add(btnUpload);
		
		JButton btnDigital = new JButton("Digital");
		btnDigital.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnDigital.setBounds(622, 165, 120, 30);
		add(btnDigital);
		
		JLabel lblDedoIndicador = new JLabel("Coloque o dedo indicador");
		lblDedoIndicador.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblDedoIndicador.setBounds(571, 216, 208, 14);
		add(lblDedoIndicador);
		
		JLabel lblOk = new JLabel("Ok!");
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblOk.setBounds(650, 244, 57, 14);
		add(lblOk);
		
		JLabel lblError = new JLabel("Aluno(a) n\u00E3o cadastrado!");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblError.setBounds(571, 269, 208, 14);
		add(lblError);

	}

}
