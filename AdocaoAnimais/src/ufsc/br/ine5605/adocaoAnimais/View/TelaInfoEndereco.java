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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaInfoEndereco extends JFrame{
    private GerenciadorBotoes btManager;
    private JLabel lbEmBranco;
    private JButton btProximo;
    private JButton btCancelar;
    // FAZER DIALOG CONFIRMANDO CANCELAR 
    
    //INFO ENDERECO
    private JLabel lbTituloInfoEndereco;
    private JLabel lbCep;
    private JTextField tfCep;
    private JLabel lbRua;
    private JTextField tfRua;
    private JLabel lbNumero;
    private JTextField tfNumero;
    private JLabel lbBairro;
    private JTextField tfBairro;
    private JLabel lbCidade;
    private JTextField tfCidade;
    private JLabel lbEstado;
    private JTextField tfEstado;
    
    public TelaInfoEndereco(){
        super("Cadastro Pessoas");
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
        
        // INFO ENDERECO
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 7;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbTituloInfoEndereco
        lbTituloInfoEndereco = new JLabel("INFORMACOES DE ENDERECO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 8;
        container.add(lbTituloInfoEndereco, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 9;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbCep
        lbCep = new JLabel("CEP: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 10;
        container.add(lbCep, cons);
        
        //Configura JTextField tfCep
        tfCep = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 11;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfCep, cons);
        
        //Configura JLabel lbRua
        lbRua = new JLabel("Rua: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 12;
        container.add(lbRua, cons);
        
        //Configura JTextField tfRua
        tfRua = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 13;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfRua, cons);

        //Configura JLabel lbNumero
        lbNumero = new JLabel("Numero: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 14;
        container.add(lbNumero, cons);
        
        //Configura JTextField tfNumero
        tfNumero = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 15;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfNumero, cons);
        
        //Configura JLabel lbBairro
        lbBairro = new JLabel("Bairro: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 16;
        container.add(lbBairro, cons);
        
        //Configura JTextField tfRua
        tfBairro = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 17;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfBairro, cons);
               
        //Configura JLabel lbCidade
        lbCidade = new JLabel("Cidade: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 18;
        container.add(lbCidade, cons);
        
        //Configura JTextField tfCidade
        tfCidade = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 19;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfCidade, cons);
        
        //Configura JLabel lbEstado
        lbEstado = new JLabel("Estado: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 20;
        container.add(lbEstado, cons);
        
        //Configura JTextField tfEstado
        tfEstado = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 21;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfEstado, cons);   
        
        
        //Configura Botao btProximo
        btProximo = new JButton("PROXIMO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 22;
        container.add(btProximo, cons);
        cons.anchor = GridBagConstraints.PAGE_END;
        btProximo.addActionListener(btManager);
        
        
       //Configura Botao btCancelar
        btCancelar = new JButton("CANCELAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 23;
        cons.anchor = GridBagConstraints.PAGE_END;
        container.add(btCancelar, cons);
        btCancelar.addActionListener(btManager);
        
        
        // Configura Frame        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
    }  
    
    private class GerenciadorBotoes implements ActionListener { 
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btCancelar)){
                ControladorPessoa.getInstancia().cancelarPreenchimento();
            }else if(ae.getSource().equals(btProximo)){
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoCep(tfCep.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoRua(tfRua.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoNumero(tfNumero.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoBairro(tfBairro.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoCidade(tfCidade.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoEstado(tfEstado.getText());
                ControladorCadastroPessoa.getInstancia().salvaInfoEndereco();
                setVisible(false);
                ControladorCadastroPessoa.getInstancia().iniciaContato();
            }
        }  
    }
}
    

