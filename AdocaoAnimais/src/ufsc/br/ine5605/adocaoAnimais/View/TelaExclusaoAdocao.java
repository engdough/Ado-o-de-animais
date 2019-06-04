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

public class TelaExclusaoAdocao extends JFrame{
	private JLabel tituloTela;
	private JLabel tituloCodigoIn;
	private JButton botaoOk;
	private JTextField textoCodigoIn;
	
    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    
    public TelaExclusaoAdocao(ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal) {
    	super("Excluir Adocao");
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	tituloCodigoIn = new JLabel();
    	botaoOk = new JButton();
    	textoCodigoIn = new JTextField();
    	
    	tituloTela.setText("TELA EXCLUSAO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	tituloCodigoIn.setText("Digite o codigo da adocao que deseja excluir");
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
        
        setSize(300,200);
        
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
            	controladorAdocao.excluirAdocao(Integer.parseInt(textoCodigoIn.getText()));
            	setVisible(false);
            	return;
            } else {
            	JOptionPane.showMessageDialog(null, "Nao foi possivel remover a adocao, pois a adocao nao esta registrada!", "Excluir Adocao", 2);
            	setVisible(false);
            	controladorAdocao.mostraMenuAdocao();
            	return;
            }
        }
        
    }

}
