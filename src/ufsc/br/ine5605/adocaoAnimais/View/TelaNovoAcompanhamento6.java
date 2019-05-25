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

public class TelaNovoAcompanhamento6 extends JFrame {
	private JLabel animalFoiVeterinario;
	private JButton botaoS;
	private JButton botaoN;
	
	private ControladorAdocao controladorAdocao;
	private ConteudoTelaAcompanhamento conteudoTelaAcompanhamento;
	private ConteudoTelaFormularioAcompanhamento formulario;
	int codigo;
	
	public TelaNovoAcompanhamento6 (ControladorAdocao controladorAdocao, ConteudoTelaAcompanhamento conteudoTelaAcompanhamento,ConteudoTelaFormularioAcompanhamento conteudoTelaFormularioAcompanhamento,int codigo) {
		super("Novo Acompanhamento");
		
		animalFoiVeterinario = new JLabel();
		botaoS = new JButton();
		botaoN = new JButton();
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
		
    	animalFoiVeterinario.setText("O animal foi ao veterianario?");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(animalFoiVeterinario,g);
    	
    	botaoS.setText("Sim");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(botaoS,g);
    	
    	botaoN.setText("Nao");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 2;
    	container.add(botaoN,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botaoS.addActionListener(btManager);
    	botaoN.addActionListener(btManager);
    	
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
			 if(ae.getSource() == botaoS) {
				 formulario.setAnimalFoiVeterinario(true);
				 setVisible(false);
				 new TelaNovoAcompanhamento7(controladorAdocao, conteudoTelaAcompanhamento, formulario, codigo);
				 return;
			 } else if (ae.getSource() == botaoN) {
				 formulario.setAnimalFoiVeterinario(false);
				 setVisible(false);
				 formulario.setMotivoIdaVeterinario("Nao se Aplica!");
				 new TelaNovoAcompanhamento8(controladorAdocao, conteudoTelaAcompanhamento, formulario, codigo);
				 return;
			 }
		 }
		
	}

}
