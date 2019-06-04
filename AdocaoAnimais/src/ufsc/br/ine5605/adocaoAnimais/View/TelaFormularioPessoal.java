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
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaFormularioPessoal extends JFrame {
    private GerenciadorBotoes btManager;
    private JLabel lbEmBranco;
    private JButton btCancelar;
    private JButton btFinalizar;
    // FAZER DIALOG CONFIRMANDO CANCELAR 
    
    // INFO FORMULARIO PESSOAL
    private JLabel lbFormularioPessoal;
    private JLabel lbMensagemPreenchimentoFormulario;
    private JLabel lbAdotouAntes;
    private JRadioButton rbSimAdotou;
    private JRadioButton rbNaoAdotou;
    private JLabel lbTemQuintal;
    private JRadioButton rbSimTemQuintal;
    private JRadioButton rbNaoTemQuintal;
    private JLabel lbTempoPassear;
    private JRadioButton rbSimTempoPassear;
    private JRadioButton rbNaoTempoPassear;
    private JLabel lbOutrosAnimais;
    private JRadioButton rbSimOutrosAnimais;
    private JRadioButton rbNaoOutrosAnimais;
    
    public TelaFormularioPessoal(){
        super("Cadastro Pessoas");
        btManager = new GerenciadorBotoes();
        configuraTela();
    }
    
    private void configuraTela() {
        JPanel container = new JPanel();
//        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        JScrollPane scrPane = new JScrollPane(container);
        scrPane.setLayout(new ScrollPaneLayout());
        getContentPane().add(scrPane);
        
        
        //Configura JLabel lbFormularioPessoal
        lbFormularioPessoal = new JLabel("FORMULARIO DE ADOCAO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 3;
        container.add(lbFormularioPessoal, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        container.add(lbEmBranco, cons);
        
                
        //Configura JLabel lbAdotouAntes
        lbAdotouAntes = new JLabel("Ja adotou algum animal antes?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(lbAdotouAntes, cons);
        
        // Configura Botao rbSimAdotou      
        rbSimAdotou = new JRadioButton("Sim");
        cons.gridx = 0;
        cons.gridy = 3;
        container.add(rbSimAdotou, cons);
        rbSimAdotou.addActionListener(btManager);
        
        // Configura Botao rbNaoAdotou      
        rbNaoAdotou = new JRadioButton("Nao");
        cons.gridx = 0;
        cons.gridy = 4;
        container.add(rbNaoAdotou, cons);
        rbNaoAdotou.addActionListener(btManager);
        
        //Configura JLabel lbTemQuintal
        lbTemQuintal = new JLabel("Na sua moradia tem quintal?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        container.add(lbTemQuintal, cons);
        
        // Configura Botao rbSimTemQuintal      
        rbSimTemQuintal = new JRadioButton("Sim");
        cons.gridx = 0;
        cons.gridy = 6;
        container.add(rbSimTemQuintal, cons);
        rbSimTemQuintal.addActionListener(btManager);
        
        // Configura Botao rbNaoTemQuintal      
        rbNaoTemQuintal = new JRadioButton("Nao");
        cons.gridx = 0;
        cons.gridy = 7;
        container.add(rbNaoTemQuintal, cons);
        rbNaoTemQuintal.addActionListener(btManager);
        
        //Configura JLabel lbTempoPassear
        lbTempoPassear = new JLabel("Voce tem tempo para passear com o animal?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 8;
        container.add(lbTempoPassear, cons);
        
        // Configura Botao rbSimTempoPassear      
        rbSimTempoPassear = new JRadioButton("Sim");
        cons.gridx = 0;
        cons.gridy = 9;
        container.add(rbSimTempoPassear, cons);
        rbSimTempoPassear.addActionListener(btManager);
        
        // Configura Botao rbNaoTempoPassear      
        rbNaoTempoPassear = new JRadioButton("Nao");
        cons.gridx = 0;
        cons.gridy = 10;
        container.add(rbNaoTempoPassear, cons);
        rbNaoTempoPassear.addActionListener(btManager);
        
                //Configura JLabel lbOutrosAnimais
        lbOutrosAnimais = new JLabel("Voce tem outros animais?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 11;
        container.add(lbOutrosAnimais, cons);
        
        // Configura Botao rbSimOutrosAnimais      
        rbSimOutrosAnimais = new JRadioButton("Sim");
        cons.gridx = 0;
        cons.gridy = 12;
        container.add(rbSimOutrosAnimais, cons);
        rbSimOutrosAnimais.addActionListener(btManager);
        
        // Configura Botao rbNaoOutrosAnimais      
        rbNaoOutrosAnimais = new JRadioButton("Nao");
        cons.gridx = 0;
        cons.gridy = 13;
        container.add(rbNaoOutrosAnimais, cons);
        rbNaoOutrosAnimais.addActionListener(btManager);
          
        //Configura Botao btCancelar
        btCancelar = new JButton("CANCELAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 14;
        container.add(btCancelar, cons);
        cons.anchor = GridBagConstraints.PAGE_END;
        btCancelar.addActionListener(btManager);
        
        
       //Configura Botao btFinalizar
        btFinalizar = new JButton("FINALIZAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 15;
        cons.anchor = GridBagConstraints.PAGE_START;
        container.add(btFinalizar, cons);
        btFinalizar.addActionListener(btManager);
        
        
        // Configura Frame      
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
    }  
    
    private class GerenciadorBotoes implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(rbSimAdotou)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoAdotouAntes(true);
            }else if (e.getSource().equals(rbNaoAdotou)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoAdotouAntes(false);
            }else if (e.getSource().equals(rbSimTemQuintal)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoTemQuintal(true);
            }else if (e.getSource().equals(rbNaoTemQuintal)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoTemQuintal(false);
            }else if (e.getSource().equals(rbSimTempoPassear)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoTemTempoPassear(true);
            }else if (e.getSource().equals(rbNaoTempoPassear)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoTemTempoPassear(false);
            }else if (e.getSource().equals(rbSimOutrosAnimais)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoTemOutrosAnimais(true);
            }else if (e.getSource().equals(rbNaoOutrosAnimais)){
                ControladorCadastroPessoa.getInstancia()
                                        .pegaInfoTemOutrosAnimais(false);
            }else if(e.getSource().equals(btFinalizar)){
                setVisible(false);
                ControladorCadastroPessoa.getInstancia().salvaInfoFormulario();
                ControladorCadastroPessoa.getInstancia().salvaCadastro();
                try {
                    ControladorPessoa.getInstancia().adicionaPessoa
                        (ControladorCadastroPessoa.getInstancia().getPessoa());
                } catch (Exception ex) {
                   System.out.println("teste");
                }
                ControladorPessoa.getInstancia().iniciaMenuPessoa();
            }else if(e.getSource().equals(btCancelar)){
                ControladorPessoa.getInstancia().cancelarPreenchimento();
            }
        }   
    }
}
