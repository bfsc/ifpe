package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.IF.Main;
import com.IF.apresentacao.ControladorTurmaJPanel;
import com.IF.entidades.Aluno;
import com.IF.negocio.ControladorCadastroAluno;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;

public class CadastrarTurmaJPanel extends JPanel {
	private JTextField textNomeMateria;
	private JTextField textNomeAluno;

	/**
	 * Create the panel.
	 */
	public CadastrarTurmaJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblCadastrarTurma = new JLabel("Cadastro de turmas");
		lblCadastrarTurma.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCadastrarTurma.setBounds(304, 44, 242, 29);
		add(lblCadastrarTurma);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new TurmasJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		
		JLabel lblNomeDaMatria = new JLabel("Nome da Mat\u00E9ria");
		lblNomeDaMatria.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNomeDaMatria.setBounds(29, 135, 167, 29);
		add(lblNomeDaMatria);
		
		textNomeMateria = new JTextField();
		textNomeMateria.setBounds(29, 164, 264, 29);
		add(textNomeMateria);
		textNomeMateria.setColumns(10);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno");
		lblNomeDoAluno.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNomeDoAluno.setBounds(29, 199, 167, 29);
		add(lblNomeDoAluno);
		
		textNomeAluno = new JTextField();
		textNomeAluno.setColumns(10);
		textNomeAluno.setBounds(29, 228, 264, 29);
		add(textNomeAluno);
		
		JLabel lblListaDeAlunos = new JLabel("Lista de Alunos cadastrados");
		lblListaDeAlunos.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblListaDeAlunos.setBounds(339, 118, 209, 14);
		add(lblListaDeAlunos);
		
		JList listAlunosCadastrados = new JList();
		listAlunosCadastrados.setBounds(322, 143, 226, 349);
		add(listAlunosCadastrados);
		
		ControladorCadastroAluno controladorCadastroAluno = new ControladorCadastroAluno();
		ArrayList<Aluno> aluno = controladorCadastroAluno.obterTodosAlunos();
		listAlunosCadastrados.setListData(aluno.toArray());

		JLabel lblListaDeAlunos_1 = new JLabel("Lista de Alunos da turma");
		lblListaDeAlunos_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblListaDeAlunos_1.setBounds(589, 118, 185, 14);
		add(lblListaDeAlunos_1);
		
		JList listAlunosDaTurma = new JList();
		listAlunosDaTurma.setBounds(564, 143, 226, 349);
		add(listAlunosDaTurma);
		button.setFont(new Font("Arial Black", Font.BOLD, 13));
		button.setBounds(35, 520, 120, 30);
		add(button);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnAdicionar.setBounds(102, 317, 120, 30);
		add(btnAdicionar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrar.setBounds(658, 520, 120, 30);
		add(btnCadastrar);

	}

}
