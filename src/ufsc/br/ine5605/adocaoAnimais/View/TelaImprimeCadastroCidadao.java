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
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaImprimeCadastroCidadao extends JFrame {
    private GerenciadorBotoes btManager;
    private String cpf;
    private Pessoa pessoa;
    
    // ------------------------ LABELS E BOTOES TELA ---------------------------  
    private JLabel lbEmBranco;
    private JLabel lbLinhas;
    private JButton btVoltar;
   
    // ----------------------- ATRIBUTOS INFO PESSOAL --------------------------
    private JLabel lbTituloInfoPessoal;
    private JLabel lbCpf;
    private JLabel lbNome;
    private JLabel lbIdade;
    
    // ---------------------- ATRIBUTOS INFO ENDERECO -------------------------
    private JLabel lbTituloInfoEndereco;
    private JLabel lbCep;
    private JLabel lbRua;
    private JLabel lbNumero;
    private JLabel lbBairro;
    private JLabel lbCidade;
    private JLabel lbEstado;
    
    // ----------------------- ATRIBUTOS INFO CONTATO -------------------------
    private JLabel lbTituloInfoContato;
    private JLabel lbEmail;
    private JLabel lbCelular;
    private JLabel lbTelFixo;
    
    // --------------------- ATRIBUTOS FORMULARIO PESSOAL ----------------------
    private JLabel lbFormularioPessoal;
    private JLabel lbAdotouAntes;
    private JLabel lbRespostaAdotouAntes;
    private JLabel lbTemQuintal;
    private JLabel lbRespostaTemQuintal;
    private JLabel lbTempoPassear;
    private JLabel lbRespostaTempoPassear;
    private JLabel lbOutrosAnimais;
    private JLabel lbRespostaOutrosAnimais;
     
    //------------------------------ CONSTRUTOR --------------------------------
       
    public TelaImprimeCadastroCidadao(String cpf){
        super("Informacoes Cidadao");
        btManager = new GerenciadorBotoes();
        this.cpf= cpf;
        pessoa = MapeadorPessoa.getInstancia().get(cpf);
        configuraTela();       
    }
    
    //------------------------------ CONFIG TELA -------------------------------
    
    private void configuraTela() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        JScrollPane scrPane = new JScrollPane(container);
        scrPane.setLayout(new ScrollPaneLayout());
        getContentPane().add(scrPane);
    
        //------------------------CONFIG COMPONENTES---------------------------
        
        //---------------------- CONFIG INFO PESSOAIS -------------------------
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbTituloInfoPessoal
        lbTituloInfoPessoal = new JLabel(">  INFORMACOES PESSOAIS");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbTituloInfoPessoal, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
   
        //Configura JLabel lbCpf
        lbCpf = new JLabel("CPF: " +pessoa.getCpf());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbCpf, cons);
        
        // Configura JLabel lbNome
        lbNome = new JLabel("Nome: " + pessoa.getNome());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbNome, cons);   

        // Configura JLabel lbIdade
        lbIdade = new JLabel("Idade: " + pessoa.getIdade());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbIdade, cons);
      
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);

        //----------------------- CONFIG INFO ENDERECO -------------------------
         
        //Configura JLabel lbTituloInfoEndereco
        lbTituloInfoEndereco = new JLabel(">  INFORMACOES DE ENDERECO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbTituloInfoEndereco, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbCep
        lbCep = new JLabel("CEP: " + pessoa.getEndereco().getCep());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbCep, cons);
           
        //Configura JLabel lbRua
        lbRua = new JLabel("Rua: " + pessoa.getEndereco().getRua());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbRua, cons);

        //Configura JLabel lbNumero
        lbNumero = new JLabel("Numero: " + pessoa.getEndereco().getNumero());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbNumero, cons);
        
        //Configura JLabel lbBairro
        lbBairro = new JLabel("Bairro: " + pessoa.getEndereco().getBairro() );
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbBairro, cons);
        
        //Configura JLabel lbCidade
        lbCidade = new JLabel("Cidade: " + pessoa.getEndereco().getCidade());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbCidade, cons);
   
        //Configura JLabel lbEstado
        lbEstado = new JLabel("Estado: " + pessoa.getEndereco().getEstado());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEstado, cons);
   
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //---------------------- CONFIG INFO CONTATO --------------------------
        
        //Configura JLabel lbTituloInfoContato
        lbTituloInfoContato = new JLabel(">  INFORMACOES CONTATO");
        cons.gridx = 0;
        cons.gridy ++;
        cons.gridwidth = 3;
        container.add(lbTituloInfoContato, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbEmail
        lbEmail = new JLabel("Email: " + pessoa.getContato().getEmail());
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmail, cons);

        // Configura JLabel lbCelular
        lbCelular= new JLabel("Celular: " + pessoa.getContato().getTelefoneCelular());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbCelular, cons);      

        // Configura JLabel lbTelFixo
        lbTelFixo = new JLabel("Telefone Fixo: " + pessoa.getContato().getTelefoneFixo());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbTelFixo, cons);
        
        //----------------- CONFIG INFO FORMULARIO PESSOAL ---------------------
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbFormularioPessoal
        lbFormularioPessoal = new JLabel("> INFORMACOES FORMULARIO ADOCAO");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        cons.gridwidth = 3;
        container.add(lbFormularioPessoal, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);       
            
        //Configura JLabel lbAdotouAntes
        lbAdotouAntes = new JLabel("--> Ja adotou algum animal antes?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbAdotouAntes, cons);
        
        //Configura JLabel lbRespostaAdotouAntes
        lbRespostaAdotouAntes = new JLabel
                    (pessoa.getFormularioPessoal().getAdotouAntes());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbRespostaAdotouAntes, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbTemQuintal
        lbTemQuintal = new JLabel("--> Na sua moradia tem quintal?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbTemQuintal, cons);
        
        //Configura JLabel lbRespostaTemQuintal
        lbRespostaTemQuintal = new JLabel
                    (pessoa.getFormularioPessoal().getTemQuintal());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbRespostaTemQuintal, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
      
        //Configura JLabel lbTempoPassear
        lbTempoPassear = new JLabel("--> Voce tem tempo para passear com o animal?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbTempoPassear, cons);
        
        //Configura JLabel lbRespostaTempoPassear
        lbRespostaTempoPassear = new JLabel
                    (pessoa.getFormularioPessoal().getTemTempoPassear());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbRespostaTempoPassear, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);
        
        //Configura JLabel lbOutrosAnimais
        lbOutrosAnimais = new JLabel("--> Voce tem outros animais?");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbOutrosAnimais, cons);
        
        //Configura JLabel lbRespostaOutrosAnimais
        lbRespostaOutrosAnimais = new JLabel
                    (pessoa.getFormularioPessoal().getTemOutrosAnimais());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbRespostaOutrosAnimais, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel(" ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(lbEmBranco, cons);

        //----------------------- CONFIG BOTOES --------------------------------
        
        //Configura Botao btVoltar
        btVoltar = new JButton("VOLTAR");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy += 2;
        container.add(btVoltar, cons);
        cons.anchor = GridBagConstraints.PAGE_END;
        btVoltar.addActionListener(btManager);          
        
        //------------------------ CONFIG FRAME --------------------------------   
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
    }  
    
    // ------------------------ GERENCIADOR BOTOES -----------------------------
    private class GerenciadorBotoes implements ActionListener {     
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btVoltar)){
                setVisible(false);
                ControladorPessoa.getInstancia().iniciaMenuPessoa();
            }
        }  
    }    
}
