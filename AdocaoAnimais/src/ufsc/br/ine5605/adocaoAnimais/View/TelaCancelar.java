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
import javax.swing.ScrollPaneLayout;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaCancelar extends JFrame {
    private GerenciadorBotoes btManager;
     private JLabel lbMensagemConfirmacao;
     private JButton btContinuar;
     private JButton btCancelar;
     
     public TelaCancelar(){
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
        
        // Configura JLabel lbMensagemConfirmacao
        lbMensagemConfirmacao = new JLabel("Ao Prosseguir com a acao, todo");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        container.add(lbMensagemConfirmacao, cons);
        
        // Configura JLabel lbMensagemConfirmacao
        lbMensagemConfirmacao = new JLabel("o progresso sera perdido!!");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        container.add(lbMensagemConfirmacao, cons);   
        
        // Configura JLabel lbMensagemConfirmacao
        lbMensagemConfirmacao = new JLabel("DESEJA CONTINUAR?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(lbMensagemConfirmacao, cons);
        
        // Configura JLabel lbMensagemConfirmacao
        lbMensagemConfirmacao = new JLabel("");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        container.add(lbMensagemConfirmacao, cons);
       
        //Configura Botao btContinuar
        btContinuar = new JButton("CONTINUAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        cons.anchor = GridBagConstraints.PAGE_END;
        container.add(btContinuar, cons);
        btContinuar.addActionListener(btManager);
        
        //Configura Botao btCancelar
        btCancelar = new JButton("CANCELAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        cons.anchor = GridBagConstraints.PAGE_END;
        container.add(btCancelar, cons);
        btCancelar.addActionListener(btManager);
        
        // Configura Frame        
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   
    }
    
     private class GerenciadorBotoes implements ActionListener {
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btCancelar)){
                    setVisible(false);
            }else if(ae.getSource().equals(btContinuar)){
                    setVisible(false);
                    ControladorPessoa.getInstancia().iniciaMenuPessoa();
            }
        }  
    }
}
