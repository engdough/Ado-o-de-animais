package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAnimal;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAcompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaFormularioAcompanhamento;

public class TelaNovoAcompanhamento1 extends JFrame{
	private JLabel tituloTela;
	private JButton botaoOK;
	private JLabel labelCodigo;
	private JTextField campoCodigoIn;
	
    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    
    public TelaNovoAcompanhamento1(ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal) {
    	super("Novo Acompanhamento");
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	labelCodigo = new JLabel();
    	botaoOK = new JButton();
    	campoCodigoIn = new JTextField();
    	
    	tituloTela.setText("ACOMPANHAMENTO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	labelCodigo.setText("Digite o codigo da Adocao");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(labelCodigo,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 2;
    	container.add(campoCodigoIn,g);
    	
    	botaoOK.setText("OK");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 1;
    	g.gridy = 2;
    	container.add(botaoOK, g);
    	
    	
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botaoOK.addActionListener(btManager);
    	
        setSize(500,200);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	this.controladorAdocao = controladorAdocao;
    	this.controladorAnimal = controladorAnimal;
    }
    
    private class GerenciadorBotoes implements ActionListener{
    	ConteudoTelaAcompanhamento conteudoTelaAcompanhamento = new ConteudoTelaAcompanhamento();
    	ConteudoTelaFormularioAcompanhamento conteudoTelaFormularioAcompanhamento = new ConteudoTelaFormularioAcompanhamento();

        @Override
        public void actionPerformed(ActionEvent ae) {
        	
        	if(controladorAdocao.codigoValido(campoCodigoIn.getText())){
        		setVisible(false);
        		new TelaNovoAcompanhamento2(controladorAdocao, conteudoTelaAcompanhamento, conteudoTelaFormularioAcompanhamento, Integer.parseInt(campoCodigoIn.getText()));
        		return;
        	} else {
        		JOptionPane.showMessageDialog(null, "O codigo de adocao nao existe", "Novo Acompanhamento", 2);
        		setVisible(false);
        		controladorAdocao.mostraMenuAdocao();
        		return;
        	}
        }
    }
}