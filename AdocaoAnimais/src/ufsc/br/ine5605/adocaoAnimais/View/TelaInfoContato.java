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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaInfoContato extends JFrame{
    private GerenciadorBotoes btManager;
    private JLabel lbEmBranco;
    private JButton btProximo;
    private JButton btCancelar;
    // FAZER DIALOG CONFIRMANDO CANCELAR 
    
    // INFO CONTATO
    private JLabel lbTituloInfoContato;
    private JLabel lbEmail;
    private JTextField tfEmail;
    private JLabel lbCelular;
    private JTextField tfCelular;
    private JLabel lbTelFixo;
    private JTextField tfTelFixo;
   
       
    public TelaInfoContato(){
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

        
        //CONFIG COMPONENTES
        
        // INFO CONTATO
        //Configura JLabel lbTituloInfoContato
        lbTituloInfoContato = new JLabel("INFORMACOES CONTATO");
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 3;
        container.add(lbTituloInfoContato, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbEmail
        lbEmail = new JLabel("Email: ");
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(lbEmail, cons);
        
        //Configura JTextField tfEmail
        tfEmail = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfEmail, cons);

        // Configura JLabel lbCelular
        lbCelular= new JLabel("Celular: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        container.add(lbCelular, cons);
        
        //Configura JTextField tfCelular
        tfCelular = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 5;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfCelular, cons);

        // Configura JLabel lbTelFixo
        lbTelFixo = new JLabel("Telefone fixo: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 6;
        container.add(lbTelFixo, cons);
        
        //Configura JTextField tfTelFixo
        tfTelFixo = new JTextField("");
        cons.gridx = 1;
        cons.gridy = 7;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfTelFixo, cons);

        
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
    
    private class GerenciadorBotoes implements ActionListener {
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btCancelar)){
                ControladorPessoa.getInstancia().cancelarPreenchimento();
            }else if(ae.getSource().equals(btProximo)){
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoEmail(tfEmail.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoCelular(tfCelular.getText());
                ControladorCadastroPessoa.getInstancia()
                                       .pegaInfoTelFixo(tfTelFixo.getText());
                ControladorCadastroPessoa.getInstancia().salvaInfoContato();
                setVisible(false);
                ControladorCadastroPessoa.getInstancia().IniciaFormulario();
            }
        }  
    }
}
