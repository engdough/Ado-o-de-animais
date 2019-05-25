package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAnimal;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAcompanhamento;

public class TelaImprimeListaAcompanhamento extends JFrame {
	private JLabel tituloTela;
	private JLabel mensagemAdocaoNaoEncontrada;
	private JButton botaoOk;
	
    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    
    public TelaImprimeListaAcompanhamento (ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal, String codigo) {
    	super("Relatório de Acompanhamentos");
    	
    	ArrayList<JLabel> labels1 = new ArrayList<>();
    	ArrayList<JLabel> labels2 = new ArrayList<>();
    	ArrayList<JLabel> labels3 = new ArrayList<>();
    	ArrayList<JLabel> labels4 = new ArrayList<>();
    	ArrayList<JLabel> labels5 = new ArrayList<>();
    	ArrayList<JLabel> labels6 = new ArrayList<>();
    	ArrayList<JLabel> labels7 = new ArrayList<>();
    	ArrayList<JLabel> labels8 = new ArrayList<>();
    	ArrayList<JLabel> labels9 = new ArrayList<>();
    	ArrayList<JLabel> labels10 = new ArrayList<>();
    	ArrayList<JLabel> labels11 = new ArrayList<>();
    	ArrayList<JLabel> labels12 = new ArrayList<>();
    	
    	
    	JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	mensagemAdocaoNaoEncontrada = new JLabel();
    	botaoOk = new JButton();
    	
    	tituloTela.setText("Lista de Acompanhamentos");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<ConteudoTelaAcompanhamento> listagemAcompanhamentos = controladorAdocao.listagemAcompanhamento(Integer.parseInt(codigo));
        	
        int i=1;
        int j=1;
        if (listagemAcompanhamentos.isEmpty()) {
        	mensagemAdocaoNaoEncontrada.setText("Essa Adocaï¿½ï¿½o ainda nï¿½o possui acompanhamentos");
            g.fill = GridBagConstraints.HORIZONTAL;
            g.gridx = 0;
            g.gridy = j;
            container.add(mensagemAdocaoNaoEncontrada,g);
        } else {
	        for (ConteudoTelaAcompanhamento acompanhamento : listagemAcompanhamentos) {
	        	
	        	labels1.add(new JLabel());
	    		labels2.add(new JLabel());
	    		labels3.add(new JLabel());
	    		labels4.add(new JLabel());
	    		labels5.add(new JLabel());
	    		labels6.add(new JLabel());
	    		labels7.add(new JLabel());
	    		labels8.add(new JLabel());
	    		labels9.add(new JLabel());
	    		labels10.add(new JLabel());
	    		labels11.add(new JLabel());
	    		labels12.add(new JLabel());
	    		
	    		labels12.get(i-1).setText(" ");
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j;
	            container.add(labels12.get(i-1),g);
	        	
	        	labels1.get(i-1).setText("Acompanhamento " + i);
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+1;
	            container.add(labels1.get(i-1),g);
	            	
	            labels2.get(i-1).setText("Funcionario: " + acompanhamento.getFuncionario());
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+2;
	            container.add(labels2.get(i-1),g);
	            	
	            labels3.get(i-1).setText("Data: " + sdf.format(acompanhamento.getData()));
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+3;
	            container.add(labels3.get(i-1),g);
	            	
	            labels4.get(i-1).setText("Animal esta bem cuidado: " + getMensagemSimNao(acompanhamento.getFormulario().isAnimalLimpo()));
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+4;
	            container.add(labels4.get(i-1),g);
	            	
	            labels5.get(i-1).setText("Animal esta bem nutrido: " + getMensagemSimNao(acompanhamento.getFormulario().isAnimalMagro()));
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+5;
	            container.add(labels5.get(i-1),g);
	            	
	            labels6.get(i-1).setText("Animal esta ferido: " + getMensagemSimNao(acompanhamento.getFormulario().isAnimalFerido()));
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+6;
	            container.add(labels6.get(i-1),g);
	            	
	            labels7.get(i-1).setText("Animal foi ao veterinario: " + getMensagemSimNao(acompanhamento.getFormulario().isAnimalFoiVeterinario()));
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+7;
	            container.add(labels7.get(i-1),g);
	            	
	            labels8.get(i-1).setText("Motivo ida ao veterinario: " + acompanhamento.getFormulario().getMotivoIdaVeterinario());
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+8;
	            container.add(labels8.get(i-1),g);
	            	
	            labels9.get(i-1).setText("Animal foi medicado: " + getMensagemSimNao(acompanhamento.getFormulario().isAnimalMedicado()));
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+9;
	            container.add(labels9.get(i-1),g);
	            	
	            labels10.get(i-1).setText("Medicamento receitado: " + acompanhamento.getFormulario().getQualMedicamento());
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+10;
	            container.add(labels10.get(i-1),g);
	            	
	            labels11.get(i-1).setText("Obs: " + acompanhamento.getFormulario().getObs());
	            g.fill = GridBagConstraints.HORIZONTAL;
	            g.gridx = 0;
	            g.gridy = j+11;
	            container.add(labels11.get(i-1),g);
	            	
	            j= j + 12;
	            i++;
	        }
        }
        	
        botaoOk.setText("OK");
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = j+1;
        container.add(botaoOk,g);
        
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botaoOk.addActionListener(btManager);
    	
        setSize(350,700);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	this.controladorAdocao = controladorAdocao;
    	this.controladorAnimal = controladorAnimal;
    }
    
    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
            
            controladorAdocao.mostraMenuAdocao();
            return;
        }
        
    }
    
    public String getMensagemSimNao(boolean mensagem) {
        if(mensagem) {
                return "SIM";
        } else {
                return "NAO";
        }
    }

}
