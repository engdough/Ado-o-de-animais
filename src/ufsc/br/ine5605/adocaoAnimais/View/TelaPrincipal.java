
package ufsc.br.ine5605.adocaoAnimais.View;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPrincipal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.ITelaPrincipal;

public class TelaPrincipal extends JFrame{
	private JLabel label;
	private JButton botaoUm;
	private JButton botaoDois;
	private JButton botaoTres;
	
    private ControladorPrincipal controladorPrincipal;
	
    public TelaPrincipal(ControladorPrincipal controladorPrincipal) {
    	super("Adocao de Animais");
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	label = new JLabel();
    	botaoUm = new JButton();
    	botaoDois = new JButton();
    	botaoTres = new JButton();
    	
    	label.setText("MENU PRINCIPAL");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(label,g);
    	
    	botaoUm.setText("MENU PESSOAS");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(botaoUm,g);
    	
    	botaoDois.setText("MENU  ANIMAIS");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 2;
    	container.add(botaoDois,g);
    	
    	botaoTres.setText("MENU ADOCOES");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 3;
    	container.add(botaoTres,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
        botaoUm.addActionListener(btManager);
        botaoDois.addActionListener(btManager);
        botaoTres.addActionListener(btManager);
        
        setSize(300,200);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        this.controladorPrincipal = controladorPrincipal;
    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == botaoUm) {
            	setVisible(false);
            	ControladorPessoa.getInstancia().iniciaMenuPessoa();
            }else if(ae.getSource() == botaoDois) {
            	setVisible(false);
            	controladorPrincipal.getInstancia().controlaMenu("2");
            } else if(ae.getSource() == botaoTres) {
            	setVisible(false);
            	controladorPrincipal.getInstancia().controlaMenu("3");
            }
        }
        
    }

}
