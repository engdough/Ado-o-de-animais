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

public class TelaNovoAcompanhamento9 extends JFrame {
	private JLabel labelMedicamentoReceitado;
	private JTextField campoMedicamento;
	private JButton botao;
	
	private ControladorAdocao controladorAdocao;
	private ConteudoTelaAcompanhamento conteudoTelaAcompanhamento;
	private ConteudoTelaFormularioAcompanhamento formulario;
	int codigo;
	
	public TelaNovoAcompanhamento9 (ControladorAdocao controladorAdocao, ConteudoTelaAcompanhamento conteudoTelaAcompanhamento,ConteudoTelaFormularioAcompanhamento conteudoTelaFormularioAcompanhamento,int codigo) {
		super("Novo Acompanhamento");
		
		labelMedicamentoReceitado = new JLabel();
		campoMedicamento = new JTextField();
		botao = new JButton();
    	
    	Container container = getContentPane();
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
		
    	labelMedicamentoReceitado.setText("Digite qual medicamento foi receitado");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(labelMedicamentoReceitado,g);
    	
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(campoMedicamento,g);
    	
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
			 formulario.setQualMedicamento(campoMedicamento.getText());
			 setVisible(false);
			 new TelaNovoAcompanhamento10(controladorAdocao, conteudoTelaAcompanhamento, formulario, codigo);
			 return;
		 }
		
	}

}
