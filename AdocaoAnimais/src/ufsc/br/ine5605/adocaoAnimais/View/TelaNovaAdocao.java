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
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAdocao;

public class TelaNovaAdocao extends JFrame{
	private JLabel tituloTela;
	private JLabel labelCodigo;
	private JTextField textoCodigoIn;
	private JLabel labelCPF;
	private JTextField textoCPFIn;
	private JButton botaoOk;
	
    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    
    public TelaNovaAdocao(ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal) {
    	super("Nova Adocao");
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	labelCodigo = new JLabel();
    	textoCodigoIn = new JTextField();
    	labelCPF = new JLabel();
    	textoCPFIn = new JTextField();
    	botaoOk = new JButton();
    	
    	
    	tituloTela.setText("NOVA ADOCAO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	labelCodigo.setText("Digite o codigo do animal");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(labelCodigo,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 2;
    	container.add(textoCodigoIn,g);
    	
    	labelCPF.setText("Digite o CPF da Pessoa");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 3;
    	container.add(labelCPF,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 4;
    	container.add(textoCPFIn,g);
    	
    	botaoOk.setText("OK");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 5;
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
        	ConteudoTelaAdocao conteudoTelaAdocao = new ConteudoTelaAdocao();

        	try{
                conteudoTelaAdocao.setAnimal(controladorAnimal.buscaAnimalCodigo(textoCodigoIn.getText()));
                } catch(Exception CadastroNaoEncontradoException){
                	JOptionPane.showMessageDialog(null, "CADASTRO DE ANIMAL NAO ENCONTRADO!", "Nova Adocao", 2);
                	setVisible(false);
                	controladorAdocao.mostraMenuAdocao();
                	return;
                    
                }
        	try{
        		conteudoTelaAdocao.setPessoa(ControladorPessoa.getInstancia().buscaPessoaCPF1(textoCPFIn.getText()));
        		
                ControladorAnimal.getInstancia().removeAnimalCodigo(textoCodigoIn.getText());
                controladorAdocao.adicionaAdocao(conteudoTelaAdocao);
                } catch (Exception CadastroNaoEncontradoException){
                	JOptionPane.showMessageDialog(null, "CADASTRO DE PESSOA NAO ENCONTRADO!", "Nova Adocao", 2);
                	setVisible(false);
                	controladorAdocao.mostraMenuAdocao();
                	return;
                }
        	
        	setVisible(false);
        	
        	
        }
        
    }

}
