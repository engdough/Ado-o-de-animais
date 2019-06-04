
package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPrincipal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaMenuPessoas extends JFrame{
    private JLabel lbTituloTela;
    private JLabel lbEmBranco;
    private JButton btAdicionaPessoa;
    private JButton btRemovePessoa;
    private JButton btAtualizaPessoa;
    private JButton btImprimeCadastroPessoa;
    private JButton btImprimeRelatorioPessoas;
    private JButton btVoltarMenuInicial;
    private GerenciadorBotoes btManager;   
       
    public TelaMenuPessoas(){
        super("Menu de Pessoas");
        btManager = new GerenciadorBotoes();
        configuraTela();
    }
    
    private void configuraTela() {
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        
        //Configuracoes dos componentes
        //Configura label lbTituloTela
        lbTituloTela = new JLabel("MENU DE CADASTRO DE PESSOAS");
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
        
       //Configura Botao btAdicionaPessoa
        btAdicionaPessoa = new JButton("ADICIONAR PESSOA");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        container.add( btAdicionaPessoa, cons);
        btAdicionaPessoa.addActionListener(btManager);
        
        //Configura Botao btRemovePessoa
        btRemovePessoa = new JButton("REMOVER PESSOA");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        container.add( btRemovePessoa, cons);
        btRemovePessoa.addActionListener(btManager);

        //Configura Botao btAtualizaPessoa       
        btAtualizaPessoa = new JButton("ATUALIZAR CADASTRO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        container.add(btAtualizaPessoa, cons);
        btAtualizaPessoa.addActionListener(btManager);

        //Configura Botao btImprimeCadastroPessoa
        btImprimeCadastroPessoa = new JButton("IMPRIMIR CADASTRO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        container.add(btImprimeCadastroPessoa, cons);
        btImprimeCadastroPessoa.addActionListener(btManager);
           
        //Configura Botao btImprimeRelatorioCadastros 
        btImprimeRelatorioPessoas = new JButton("VISUALIZAR REGISTROS");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 6;
        container.add(btImprimeRelatorioPessoas, cons);
        btImprimeRelatorioPessoas.addActionListener(btManager);
        
        //Configura Botao btImprimeRelatorioCadastros 
        btVoltarMenuInicial = new JButton("VOLTAR MENU INICIAL");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 7;
        container.add(btVoltarMenuInicial, cons);
        btVoltarMenuInicial.addActionListener(btManager);
        
        // Configura Frame      
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
    }  
    
    private class GerenciadorBotoes implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {    
            //--------------------- ADICIONA PESSOA ---------------------------
            if (ae.getSource().equals(btAdicionaPessoa)){
                setVisible(false);
                ControladorCadastroPessoa.getInstancia().iniciaInfoPessoal();  
            //---------------------- REMOVE PESSOA ----------------------------
            }else if(ae.getSource().equals(btRemovePessoa)){
                setVisible(false);
                ControladorPessoa.getInstancia().iniciaMenuExcluirPessoa();
            //---------------------- ATUALIZA PESSOA ---------------------------
            }else if(ae.getSource().equals(btAtualizaPessoa)){
                ControladorPessoa.getInstancia().SelecionaCadastroAtualizar();
            //----------------- IMPRIME RELATORIO PESSOA ----------------------
            }else if(ae.getSource().equals(btImprimeRelatorioPessoas)){
                setVisible(false);
                ControladorPessoa.getInstancia()
                                .iniciaRelatorioPessoasCadastradas();
            //------------------ IMPRIME CADASTRO PESSOA ----------------------
            }else if(ae.getSource().equals(btImprimeCadastroPessoa)){
                setVisible(false);
                ControladorPessoa.getInstancia().selecionaCadastroImprimir();
            // ------------------- VOLTA MENU INICIAL -------------------------
            }else if(ae.getSource().equals(btVoltarMenuInicial)){
                setVisible(false);
                ControladorPrincipal.getInstancia().iniciaSistema();
            }
        }  
    }
}