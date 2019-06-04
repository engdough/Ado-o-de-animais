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

import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorAnimal;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAdocao;

public class TelaListaAdocoes extends JFrame {
	private JLabel tituloTela;
	private JLabel colunaCodigo;
	private JLabel colunaData;
	private JLabel colunaCPF;
	private JLabel colunaNome;
	private JLabel colunaAcompanhamento;
	private JButton botaoOk;
	
    private ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    
    public TelaListaAdocoes(ControladorAdocao controladorAdocao, ControladorAnimal controladorAnimal, ArrayList<ConteudoTelaAdocao> listaAdocoes) {
    	super("Relatorio de Adocoes Cadastradas");
    	
    	ArrayList<JLabel> arrayColunaCodigo = new ArrayList<>();
    	ArrayList<JLabel> arrayColunaData = new ArrayList<>();
    	ArrayList<JLabel> arrayColunaCPF = new ArrayList<>();
    	ArrayList<JLabel> arrayColunaNome = new ArrayList<>();
    	ArrayList<JLabel> arrayColunaAcompanhamento = new ArrayList<>();
    	
    	JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints g = new GridBagConstraints();
    	
    	tituloTela = new JLabel();
    	colunaCodigo = new JLabel();
    	colunaData = new JLabel();
    	colunaCPF = new JLabel();
    	colunaNome = new JLabel();
    	colunaAcompanhamento = new JLabel();
    	botaoOk = new JButton();
    	
    	
    	tituloTela.setText("LISTA DE ADOCOES");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 0;
    	container.add(tituloTela,g);
    	
    	colunaCodigo.setText("CODIGO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = 1;
    	container.add(colunaCodigo,g);
    	
    	colunaData.setText("DATA ADOCAO          ");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 1;
    	g.gridy = 1;
    	container.add(colunaData,g);
    	
    	colunaCPF.setText("CPF PESSOA           ");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 2;
    	g.gridy = 1;
    	container.add(colunaCPF,g);
    	
    	colunaNome.setText("NOME PESSOA        ");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 3;
    	g.gridy = 1;
    	container.add(colunaNome,g);
    	
    	colunaAcompanhamento.setText("QUANTIDADE ACOMPANHAMENTO");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 4;
    	g.gridy = 1;
    	container.add(colunaAcompanhamento,g);
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	int i = 0;
    	
    	for(ConteudoTelaAdocao conteudoAdocao : listaAdocoes) {
    		
    		arrayColunaCodigo.add(new JLabel());
    		arrayColunaData.add(new JLabel());
    		arrayColunaCPF.add(new JLabel());
    		arrayColunaNome.add(new JLabel());
    		arrayColunaAcompanhamento.add(new JLabel());
    		
    		arrayColunaCodigo.get(i).setText(Integer.toString(conteudoAdocao.getCodigo()));
        	g.fill = GridBagConstraints.HORIZONTAL;
        	g.gridx = 0;
        	g.gridy = i+2;
        	container.add(arrayColunaCodigo.get(i),g);
        	
        	arrayColunaData.get(i).setText(sdf.format(conteudoAdocao.getData()));
        	g.fill = GridBagConstraints.HORIZONTAL;
        	g.gridx = 1;
        	g.gridy = i+2;
        	container.add(arrayColunaData.get(i),g);
        	
        	arrayColunaCPF.get(i).setText(conteudoAdocao.getPessoa().getCpf());
        	g.fill = GridBagConstraints.HORIZONTAL;
        	g.gridx = 2;
        	g.gridy = i+2;
        	container.add(arrayColunaCPF.get(i),g);
        	
        	arrayColunaNome.get(i).setText(conteudoAdocao.getPessoa().getNome());
        	g.fill = GridBagConstraints.HORIZONTAL;
        	g.gridx = 3;
        	g.gridy = i+2;
        	container.add(arrayColunaNome.get(i),g);
        	
        	arrayColunaAcompanhamento.get(i).setText(Integer.toString(conteudoAdocao.getAcompanhamento().size()));
        	g.fill = GridBagConstraints.HORIZONTAL;
        	g.gridx = 4;
        	g.gridy = i+2;
        	container.add(arrayColunaAcompanhamento.get(i),g);
        	
        	i++;
            }
    	
    	botaoOk.setText("OK");
    	g.fill = GridBagConstraints.HORIZONTAL;
    	g.gridx = 0;
    	g.gridy = i+2;
    	container.add(botaoOk,g);
    	
    	GerenciadorBotoes btManager = new GerenciadorBotoes();
    	botaoOk.addActionListener(btManager);
        
        setSize(800,300);
        
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

}
