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

public class TelaNovoAcompanhamento10 extends JFrame {
	private JLabel tituloObs;
	private JTextField campoObs;
	private JButton botaoOk;
	
	private ControladorAdocao controladorAdocao;
	private ConteudoTelaAcompanhamento conteudoTelaAcompanhamento;
	private ConteudoTelaFormularioAcompanhamento formulario;
	int codigo;
	
	public TelaNovoAcompanhamento10 (ControladorAdocao controladorAdocao, ConteudoTelaAcompanhamento conteudoTelaAcompanhamento,ConteudoTelaFormularioAcompanhamento conteudoTelaFormularioAcompanhamento,int codigo) {
		super("Novo Acompanhamento");
		
		tituloObs = new JLabel();
		campoObs = new JTextField();
		botaoOk = new JButton();
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
		
    	tituloObs.setText("Digite as Observacoes do acompanhamento");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloObs,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(campoObs,g);
    	
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
			 formulario.setObs(campoObs.getText());
			 setVisible(false);
			 controladorAdocao.adicionaAcompanhamento(conteudoTelaAcompanhamento, formulario, codigo);
			 return;
		 }
		
	}

}
