package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import com.IF.Main;
import com.IF.apresentacao.ControladorDisciplinaJPanel;
import com.IF.entidades.Disciplina;
import com.IF.negocio.ControladorCadastroDisciplina;
import com.IF.apresentacao.ChamadaJPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;

public class DisciplinaJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisciplinaJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblDisciplinas = new JLabel("Disciplinas");
		lblDisciplinas.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblDisciplinas.setBounds(357, 47, 108, 29);
		add(lblDisciplinas);
		
		JList listListaDisciplina = new JList();
		listListaDisciplina.setBounds(202, 119, 401, 159);
		add(listListaDisciplina);
		
		ControladorCadastroDisciplina controladorCadastroDisciplina = new ControladorCadastroDisciplina();
		Set<Disciplina> disciplina = controladorCadastroDisciplina.obterTodasAsDisciplinas();
		listListaDisciplina.setListData(disciplina.toArray());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new ControladorDisciplinaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnVoltar.setBounds(54, 520, 120, 30);
		add(btnVoltar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new CadastrarDisciplinaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		btnAtualizar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnAtualizar.setBounds(345, 327, 120, 30);
		add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Disciplina disciplina =  (Disciplina) listListaDisciplina.getSelectedValue();
				
				ControladorCadastroDisciplina controladorCadastroDisciplina = new ControladorCadastroDisciplina();
				controladorCadastroDisciplina.deletarDisciplina(disciplina);
				
				Set<Disciplina> disciplinas = controladorCadastroDisciplina.obterTodasAsDisciplinas();
				listListaDisciplina.setListData(disciplinas.toArray());
				
			}
		});
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
