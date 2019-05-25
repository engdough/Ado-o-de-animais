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

public class TelaNovoAcompanhamento7 extends JFrame {
	private JLabel motivoIdaVeterinario;
	private JTextField campoMotivoIdaVeterinario;
	private JButton botao;
	
	private ControladorAdocao controladorAdocao;
	private ConteudoTelaAcompanhamento conteudoTelaAcompanhamento;
	private ConteudoTelaFormularioAcompanhamento formulario;
	int codigo;
	
	public TelaNovoAcompanhamento7 (ControladorAdocao controladorAdocao, ConteudoTelaAcompanhamento conteudoTelaAcompanhamento,ConteudoTelaFormularioAcompanhamento conteudoTelaFormularioAcompanhamento,int codigo) {
		super("Novo Acompanhamento");
		
		motivoIdaVeterinario = new JLabel();
		campoMotivoIdaVeterinario = new JTextField();
		botao = new JButton();
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
		
    	motivoIdaVeterinario.setText("Digite o motivo da ida ao veterinario");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(motivoIdaVeterinario,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(campoMotivoIdaVeterinario,g);
    	
    	botao.setText("OK");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 1;
    	g.gridy = 1;
    	container.add(botao,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botao.addActionListener(btManager);
    	
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
			 formulario.setMotivoIdaVeterinario(campoMotivoIdaVeterinario.getText());
			 setVisible(false);
			 new TelaNovoAcompanhamento8(controladorAdocao, conteudoTelaAcompanhamento, formulario, codigo);
			 return;
		 }
		
	}

}
