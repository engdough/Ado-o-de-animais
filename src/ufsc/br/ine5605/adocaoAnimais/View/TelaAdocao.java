package ufsc.br.ine5605.adocaoAnimais.View;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAnimal;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.ITelaAdocao;

public class TelaAdocao extends JFrame{
	private JLabel tituloTela;
	private JButton cadastrarAdocao;
	private JButton inserirAcompanhamento;
	private JButton removerAdocao;
	private JButton imprimirAdocoes;
	private JButton imprimirAcompanhamento;
	private JButton menuPrincipal;

    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;


    public TelaAdocao(ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal){
    	super("Cadastro Adocao");
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	cadastrarAdocao = new JButton();
    	inserirAcompanhamento = new JButton();
    	removerAdocao = new JButton();
    	imprimirAdocoes = new JButton();
    	imprimirAcompanhamento = new JButton();
    	menuPrincipal = new JButton();
    	
    	tituloTela.setText("MENU DO CADASTRO DE ADOCOES");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	cadastrarAdocao.setText("CADASTRAR ADOCAO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(cadastrarAdocao,g);
    	
    	inserirAcompanhamento.setText("INSERIR ACOMPANHAMENTO A ADOCAO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 2;
    	container.add(inserirAcompanhamento,g);
    	
    	removerAdocao.setText("REMOVER ADOCAO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 3;
    	container.add(removerAdocao,g);
    	
    	imprimirAdocoes.setText("IMPRIMIR RELATORIO DE ADOCOES");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 4;
    	container.add(imprimirAdocoes,g);
    	
    	imprimirAcompanhamento.setText("IMPRIMIR ACOMPANHAMENTO DE ADOCAO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 5;
    	container.add(imprimirAcompanhamento,g);
    	
    	menuPrincipal.setText("VOLTAR MENU PRINCIPAL");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 6;
    	container.add(menuPrincipal,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	cadastrarAdocao.addActionListener(btManager);
    	inserirAcompanhamento.addActionListener(btManager);
    	removerAdocao.addActionListener(btManager);
    	imprimirAdocoes.addActionListener(btManager);
    	imprimirAcompanhamento.addActionListener(btManager);
    	menuPrincipal.addActionListener(btManager);
        
        setSize(400,300);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	this.controladorAdocao = controladorAdocao;
    	this.controladorAnimal = controladorAnimal;
    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == cadastrarAdocao) {
            	setVisible(false);
            	controladorAdocao.executaMenuAdocao("1");
            	return;
            }else if(ae.getSource() == inserirAcompanhamento) {
            	setVisible(false);
            	controladorAdocao.executaMenuAdocao("2");
            	return;
            } else if(ae.getSource() == removerAdocao) {
            	setVisible(false);
            	controladorAdocao.executaMenuAdocao("3");
            	return;
            } else if(ae.getSource() == imprimirAdocoes) {
            	setVisible(false);
            	controladorAdocao.executaMenuAdocao("4");
            	return;
            } else if(ae.getSource() == imprimirAcompanhamento) {
            	setVisible(false);
            	controladorAdocao.executaMenuAdocao("5");
            	return;
            } else if(ae.getSource() == menuPrincipal) {
            	setVisible(false);
            	controladorAdocao.executaMenuAdocao("0");
            	return;
            }
        }
        
    }
}
