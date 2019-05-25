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

public class TelaListaAcompanhamentoVerificaCodigoAdocao extends JFrame {
	private JLabel tituloTela;
	private JLabel tituloCodigoIn;
	private JTextField textoCodigoIn;
	private JButton botaoOk;
	
    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    
    public TelaListaAcompanhamentoVerificaCodigoAdocao (ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal) {
    	super("Lista de Acompanhamentos");
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	tituloCodigoIn = new JLabel();
    	botaoOk = new JButton();
    	textoCodigoIn = new JTextField();
    	
    	tituloTela.setText("MENU DO CADASTRO DE ADOCOES");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	tituloCodigoIn.setText("Digite o codigo da adocao que deseja listar os acompanhamentos");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(tituloCodigoIn,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 2;
    	container.add(textoCodigoIn,g);
    	
    	botaoOk.setText("OK");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 3;
    	container.add(botaoOk,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botaoOk.addActionListener(btManager);
    	
        setSize(800,200);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	this.controladorAdocao = controladorAdocao;
    	this.controladorAnimal = controladorAnimal;
    	
    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (controladorAdocao.codigoValido(textoCodigoIn.getText())) {
            	setVisible(false);
            	
            	new TelaImprimeListaAcompanhamento(controladorAdocao, controladorAnimal, textoCodigoIn.getText());
            	return;
            	
            } else {
        		JOptionPane.showMessageDialog(null, "O codigo de adocao nao existe", "Lista de Acompanhamentos", 2);
        		setVisible(false);
        		controladorAdocao.mostraMenuAdocao();
        		return;
        	}
            
            
        }
        
    }
}
