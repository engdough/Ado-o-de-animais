/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Exception.CadastroNaoEncontradoException;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IControladorPessoa {
    public void iniciaMenuPessoa();
    public void controlaMenu();
    public String pegaInfoOpcao();
    public void adicionaPessoa();
    public void removePessoa();
    public void removePessoaCpf(String cpf);
    public void atualizaPessoa();
    public Pessoa buscaPessoaCPF(String CPF)
            throws CadastroNaoEncontradoException;   
    public void imprimeRelatorioPessoasCadastradas();
    public void imprimeCadastroPessoa();
    public void imprimeInformacoesPessoa(Pessoa pessoa);    
    public void imprimeInformacoesEndereco(Pessoa pessoa);   
    public void imprimeInformacoesContato(Pessoa pessoa);
    public void imprimeInformacoesFormularioPessoal(Pessoa pessoa);
    public boolean validaOpcao(String opcao);
    public boolean cpfJaCadastrado(String cpf);
    public boolean validaCpf(String cpf);
}
