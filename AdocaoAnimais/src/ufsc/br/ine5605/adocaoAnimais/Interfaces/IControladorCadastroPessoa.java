/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Model.Contato;
import ufsc.br.ine5605.adocaoAnimais.Model.Endereco;
import ufsc.br.ine5605.adocaoAnimais.Model.FormularioPessoal;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IControladorCadastroPessoa {
    
    public Pessoa pegaInformacoesTela(String CPF);
    public void pegaInformacoesPessoais(String CPF);    
    public Endereco pegaInformacoesEndereco();   
    public Contato pegaInformacoesContato();    
    public FormularioPessoal pegaInformacoesFormularioPessoal();
    public String pegaInfoNome();
    public String pegaInfoIdade();
    public void pegaInfoCep();
    public void pegaInfoRua();
     public void pegaInfoNumero();
    public void pegaInfoBairro();
    public void pegaInfoCidade();
    public void pegaInfoEstado();
    public void pegaInfoEmail();
    public void pegaInfoCelular();
    public void pegaInfoTelefoneFixo();
    public void pegaInfoAdotouAntes();
    public void pegaInfoTemQuintal();
    public void pegaInfoTemTempoPassear();
    public void pegaInfoTemOutrosAnimais();
    public boolean pegaInfoBooleana(String mensagem);
    public boolean validaCep(String cep);
    public boolean validaIdade(String idade);
    public boolean validaTelefone(String numero);
}
