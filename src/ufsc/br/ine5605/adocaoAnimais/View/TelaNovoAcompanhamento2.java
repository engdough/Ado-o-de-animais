package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAcompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaFormularioAcompanhamento;

public class TelaNovoAcompanhamento2 extends JFrame {
	private JLabel labelFuncionario;
	private JTextField funcionarioIn;
	private JButton botaoOk;
	
	private ControladorAdocao controladorAdocao;
	private ConteudoTelaAcompanhamento conteudoTelaAcompanhamento;
	private ConteudoTelaFormularioAcompanhamento formulario;
	int codigo;
	
	public TelaNovoAcompanhamento2 (ControladorAdocao controladorAdocao, ConteudoTelaAcompanhamento conteudoTelaAcompanhamento,ConteudoTelaFormularioAcompanhamento conteudoTelaFormularioAcompanhamento,int codigo) {
		super("Novo Acompanhamento");
		
		labelFuncionario = new JLabel();
		funcionarioIn = new JTextField();
		botaoOk = new JButton();
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
		
    	labelFuncionario.setText("Digite o nome do funcionario que esta acompanhando");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(labelFuncionario,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(funcionarioIn,g);
    	
    	botaoOk.setText("OK");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 1;
    	g.gridy = 1;
    	container.add(botaoOk,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botaoOk.addActionListener(btManager);
    	
    	setSize(500,200);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
		this.controladorAdocao = controladorAdocao;
		this.conteudoTelaAcompanhamento = conteudoTelaAcompanhamento;
		this.formulario = conteudoTelaFormularioAcompanhamento;
		this.codigo = codigo;
	}
	
	private class GerenciadorBotoes implements ActionListener{
		 @Override
		public void actionPerformed(ActionEvent ae) {
			 conteudoTelaAcompanhamento.setFuncionario(funcionarioIn.getText());
			 setVisible(false);
			 new TelaNovoAcompanhamento3(controladorAdocao, conteudoTelaAcompanhamento, formulario, codigo);
			 return;
		 }
		
	}

}
