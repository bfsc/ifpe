package com.IF.apresentacao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import com.IF.Main;
import com.IF.apresentacao.ControladorDisciplinaJPanel;
import com.IF.entidades.Aluno;
import com.IF.entidades.Disciplina;
import com.IF.excecoes.AlunoInvalidoException;
import com.IF.excecoes.DisciplinaInvalidaException;
import com.IF.negocio.ControladorCadastroAluno;
import com.IF.negocio.ControladorCadastroDisciplina;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;

public class CadastrarDisciplinaJPanel extends JPanel {
	private JTextField textNomeDisciplina;
	private JTextField textNomeAluno;

	/**
	 * Create the panel.
	 */
	public CadastrarDisciplinaJPanel() {
		setLayout(null);
		setSize(800, 600);
		
		JLabel lblCadastrarDisciplina = new JLabel("Cadastro de Disciplinas");
		lblCadastrarDisciplina.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCadastrarDisciplina.setBounds(304, 44, 286, 29);
		add(lblCadastrarDisciplina);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getFrame().setContentPane(new DisciplinaJPanel());
				Main.getFrame().getContentPane().revalidate();
			}
		});
		
		JLabel lblNomeDaDisciplina = new JLabel("Nome da Disciplina");
		lblNomeDaDisciplina.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNomeDaDisciplina.setBounds(29, 135, 185, 29);
		add(lblNomeDaDisciplina);
		
		textNomeDisciplina = new JTextField();
		textNomeDisciplina.setBounds(29, 164, 264, 29);
		add(textNomeDisciplina);
		textNomeDisciplina.setColumns(10);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno");
		lblNomeDoAluno.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNomeDoAluno.setBounds(29, 199, 167, 29);
		add(lblNomeDoAluno);
		
		textNomeAluno = new JTextField();
		textNomeAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ControladorCadastroAluno controladorCadastroAluno = new ControladorCadastroAluno();
				controladorCadastroAluno.buscarAlunoPorNome(textNomeAluno.getText());
				
			}
		});
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
		Set<Aluno> aluno = controladorCadastroAluno.obterTodosAlunos();
		listAlunosCadastrados.setListData(aluno.toArray());

		JLabel lblListaDeAlunos_1 = new JLabel("Lista de Alunos da Disciplina");
		lblListaDeAlunos_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblListaDeAlunos_1.setBounds(589, 118, 185, 14);
		add(lblListaDeAlunos_1);
		
		JList listAlunosDaDisciplina = new JList();
		listAlunosDaDisciplina.setBounds(564, 143, 226, 349);
		add(listAlunosDaDisciplina);
		button.setFont(new Font("Arial Black", Font.BOLD, 13));
		button.setBounds(35, 520, 120, 30);
		add(button);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Aluno aluno = (Aluno) listAlunosCadastrados.getSelectedValue();
				
				
	
				
			}
		});
		btnAdicionar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnAdicionar.setBounds(102, 317, 120, 30);
		add(btnAdicionar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Instanciando o objeto disciplina
				Disciplina disciplina = new Disciplina();
				
				//Pegando os atributos do campo de texto e setando aos atributos do objeto
				disciplina.setNome(textNomeDisciplina.getText());
				
				try {
					
					//Jogando o objeto disciplina ao controlador para passar pela validação
					ControladorCadastroDisciplina controladorCadastroDisciplina = new ControladorCadastroDisciplina();
					controladorCadastroDisciplina.CadastrarDisciplina(disciplina);
					
					//Chamando o dialog caso a disciplina seja cadastrada com sucesso
					DisciplinaCadastrada dialogDisciplinaCadastrada = new DisciplinaCadastrada();
					dialogDisciplinaCadastrada.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogDisciplinaCadastrada.setLocationRelativeTo(null);
					dialogDisciplinaCadastrada.setVisible(true);
					
				}  catch (DisciplinaInvalidaException excecao) {
					
					//Chamando o dialog se o nome da disciplina seja vazio
					if(excecao.isNomeDisciplinaVazio()) {
						
						NomeDisciplinaVazio dialogNomeDisciplinaVazio = new NomeDisciplinaVazio();
						dialogNomeDisciplinaVazio.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialogNomeDisciplinaVazio.setLocationRelativeTo(null);
						dialogNomeDisciplinaVazio.setVisible(true);
						
					}
					
				}
				
				textNomeDisciplina.setText("");
				
			}
		});
		btnCadastrar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCadastrar.setBounds(658, 520, 120, 30);
		add(btnCadastrar);

	}

}
