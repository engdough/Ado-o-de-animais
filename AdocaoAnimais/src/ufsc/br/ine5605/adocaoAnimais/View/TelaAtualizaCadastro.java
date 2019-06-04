/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaAtualizaCadastro extends JFrame {
   
    private Pessoa pessoa;
    private String cpf;
    private GerenciadorBotoes btManager;
    private JLabel lbEmBranco;
    private JButton btProximo;
    private JButton btCancelar;
    // FAZER DIALOG CONFIRMANDO CANCELAR 
   
    // INFO PESSOAL
    private JLabel lbTituloInfoPessoal;
    private JLabel lbCpf;
    private JLabel lbRespostaCpf;
    private JLabel lbNome;
    private JTextField tfNome;
    private JLabel lbIdade;
    private JTextField tfIdade;
   
       
    public TelaAtualizaCadastro(Pessoa pessoa){
        super("Atualizar Cadastro");
        btManager = new GerenciadorBotoes();
        this.pessoa = pessoa;
        this.cpf = pessoa.getCpf();
        configuraTela();
        
    }
    
    private void configuraTela() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        JScrollPane scrPane = new JScrollPane(container);
        scrPane.setLayout(new ScrollPaneLayout());
        getContentPane().add(scrPane);

        
        //CONFIG COMPONENTES
        
        // INFO PESSOAIS
        //Configura JLabel lbTituloTela
        lbTituloInfoPessoal = new JLabel("INFORMACOES PESSOAIS");
//        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 3;
        container.add(lbTituloInfoPessoal, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel("");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbCpf
        lbCpf = new JLabel("CPF: " + cpf);
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(lbCpf, cons);

        // Configura JLabel lbNome
        lbNome = new JLabel("Nome: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        container.add(lbNome, cons);
        
        //Configura JTextField tfNome
        tfNome = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 5;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfNome, cons);

        // Configura JLabel lbIdade
        lbIdade = new JLabel("Idade: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 6;
        container.add(lbIdade, cons);
        
        //Configura JTextField tfIdade
        tfIdade = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 7;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfIdade, cons);
        
        //Configura Botao btProximo
        btProximo = new JButton("PROXIMO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 10;
        container.add(btProximo, cons);
        cons.anchor = GridBagConstraints.PAGE_END;
        btProximo.addActionListener(btManager);   
        
       //Configura Botao btCancelar
        btCancelar = new JButton("CANCELAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 11;
        cons.anchor = GridBagConstraints.PAGE_START;
        container.add(btCancelar, cons);
        btCancelar.addActionListener(btManager);
        
        
        // Configura Frame      
        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
    }  
    
    public void erroIdade(){
        tfIdade.setBackground(Color.RED);
        lbIdade.setForeground(Color.RED);
        repaint();
    }
    
    public void erroCampoEmBranco(JTextField tfErro, JLabel lbErro){
        tfErro.setBackground(Color.RED);
        lbErro.setForeground(Color.RED);
    }
    public void campoCorrigido(JTextField tfCorrigido, JLabel lbCorrigido){
        tfCorrigido.setBackground(Color.WHITE);
        lbCorrigido.setForeground(Color.BLACK);   
    }
    
    private class GerenciadorBotoes implements ActionListener {     
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btCancelar)){
                ControladorPessoa.getInstancia().cancelarPreenchimento();
            }else if(ae.getSource().equals(btProximo)){
                boolean semErro = false;
                ControladorCadastroPessoa.getInstancia().pegaInfoCpf(cpf);
                try {
                    ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoNome(tfNome.getText());
                        campoCorrigido(tfNome, lbNome);
                        semErro = true;
                } catch (Exception ex) {
                            erroCampoEmBranco(tfNome,lbNome);
                        semErro= false;
                }
                try {
                    ControladorCadastroPessoa.getInstancia()
                            .pegaInfoIdade(tfIdade.getText());
                            campoCorrigido(tfIdade, lbIdade);
                        semErro = true;
                } catch (Exception ex) {
                            erroCampoEmBranco(tfIdade,lbIdade);
                        semErro = false;
                }
                if(semErro){
                setVisible(false);
                ControladorCadastroPessoa.getInstancia().iniciaEndereco();
                }
            }
        }  
    }
}
