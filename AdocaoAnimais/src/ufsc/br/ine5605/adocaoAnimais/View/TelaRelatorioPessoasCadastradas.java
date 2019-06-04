/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaRelatorioPessoasCadastradas extends JFrame {
    private GerenciadorBotoes btManager;
    private JLabel lbEmBranco;
    private JLabel lbLinhas;
    private JLabel lbTituloTela;
    private JLabel lbTituloNome;
    private JLabel lbTitulCPF;
    private JLabel lbInfoNome;
    private JLabel lbInfoCpf;
    private JButton btVoltar;
    
    public  TelaRelatorioPessoasCadastradas(){
        super("Pessoas Cadastradas");
//        MapeadorPessoa.getInstancia().load();
//        repaint();
        btManager = new GerenciadorBotoes();
        configuraTela();
    }
    
    private void configuraTela() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        JScrollPane scrPane = new JScrollPane(container);
        scrPane.setLayout(new ScrollPaneLayout());
        getContentPane().add(scrPane);
        
        //Configura JLabel lbTituloTela
        lbTituloTela = new JLabel("RELATORIO PESSOAS CADASTRADAS");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        container.add(lbTituloTela, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbTituloNome
        lbTituloNome = new JLabel("NOME");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(lbTituloNome, cons);
        
        //Configura JLabel lbTitulCPF
        lbTitulCPF = new JLabel("CPF");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 2;
        container.add(lbTitulCPF, cons);
    
        //     IMPRIME LISTA
        
        int linha = 4;
        for (Pessoa pessoa: MapeadorPessoa.getInstancia().getList()){
            //Configura JLabel lbInfoNome
            lbInfoNome = new JLabel(pessoa.getNome());
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 0;
            cons.gridy = linha;
            container.add(lbInfoNome, cons);
            
            //Configura JLabel lbLinhas
            lbLinhas = new JLabel("--------------------------------------" +
                    "---------------------");
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 0;
            cons.gridy = linha + 2;
            container.add(lbLinhas, cons);
            
            //Configura JLabel lbInfoCpf
            lbInfoCpf = new JLabel(pessoa.getCpf());
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 1;
            cons.gridy = linha;
            container.add(lbInfoCpf, cons);
            
            //Configura JLabel lbLinhas
            lbLinhas = new JLabel("---------------------------------");
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 1;
            cons.gridy = linha + 2;
            container.add(lbLinhas, cons);    
            linha += 3;  
        }
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //Configura Botao btVoltar
        btVoltar = new JButton("VOLTAR");   
        cons.anchor = GridBagConstraints.PAGE_END;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(btVoltar, cons);
        btVoltar.addActionListener(btManager);
        
            
        // Configura Frame        
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
   
    }    
    
    private class GerenciadorBotoes implements ActionListener{ 
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btVoltar)){
                setVisible(false);
                ControladorPessoa.getInstancia().iniciaMenuPessoa();
            }
        }
    }       
}
    
