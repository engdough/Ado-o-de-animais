/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Controller;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import java.util.ArrayList;
import java.util.Collection;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Exception.CadastroJahExisteException;
import ufsc.br.ine5605.adocaoAnimais.Exception.CadastroNaoEncontradoException;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;
import ufsc.br.ine5605.adocaoAnimais.View.TelaPessoa;
import ufsc.br.ine5605.adocaoAnimais.Exception.RespostaInvalidaException;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorPessoa;
import ufsc.br.ine5605.adocaoAnimais.View.TelaAtualizaCadastro;
import ufsc.br.ine5605.adocaoAnimais.View.TelaCadastroNaoEncontrado;
import ufsc.br.ine5605.adocaoAnimais.View.TelaCancelar;
import ufsc.br.ine5605.adocaoAnimais.View.TelaEscolheCadastroImprimir;
import ufsc.br.ine5605.adocaoAnimais.View.TelaEscolherCadastroAtualizar;
import ufsc.br.ine5605.adocaoAnimais.View.TelaImprimeCadastroCidadao;
import ufsc.br.ine5605.adocaoAnimais.View.TelaMenuPessoas;
import ufsc.br.ine5605.adocaoAnimais.View.TelaRelatorioPessoasCadastradas;
import ufsc.br.ine5605.adocaoAnimais.View.TelaRemoverPessoa;
/**
 *
 * @author Ana Elisa Kruger
 */
public class ControladorPessoa {
    // implements IControladorPessoa 
    // fazer esquema pro controlador ser unico depois
    private TelaPessoa telaPessoa = new TelaPessoa();
    private TelaMenuPessoas telaMenuPessoas = new TelaMenuPessoas();
    private TelaRemoverPessoa telaRemoverPessoa = new TelaRemoverPessoa();
    private TelaRelatorioPessoasCadastradas telaPessoasCadastradas;
    private TelaEscolheCadastroImprimir telaEscolheCadastroImprimir =
                                     new TelaEscolheCadastroImprimir();
    private TelaEscolherCadastroAtualizar telaEscolherCadastroAtualizar
                                    = new TelaEscolherCadastroAtualizar();
    private TelaAtualizaCadastro telaAtualizaCadastro;
    private TelaCadastroNaoEncontrado telaCadastroNaoEncontrado =
                        new TelaCadastroNaoEncontrado();
    private TelaCancelar telaCancelar = new TelaCancelar();
    
    private static ControladorPessoa instancia;
    
    public ControladorPessoa(){  
    }
    
     public static ControladorPessoa getInstancia(){
        if (instancia == null){
        instancia = new ControladorPessoa();
        } 
        return instancia;
    }
    // INICIA TELAS 
    public void iniciaMenuPessoa(){
        telaMenuPessoas.setVisible(true);
        ControladorCadastroPessoa.getInstancia().desativaTelas();
        if(telaAtualizaCadastro != null){
            telaAtualizaCadastro.setVisible(false);
        }
    }
    
    public void iniciaMenuExcluirPessoa(){
        telaRemoverPessoa.setVisible(true);
    }
    
    public void iniciaRelatorioPessoasCadastradas(){
        telaPessoasCadastradas = new TelaRelatorioPessoasCadastradas();
        telaPessoasCadastradas.setVisible(true);
    }
    
    public void selecionaCadastroImprimir(){
        telaEscolheCadastroImprimir.setVisible(true);
    }
    
    public void SelecionaCadastroAtualizar(){
        telaEscolherCadastroAtualizar.setVisible(true);
    }
    //ATUALIZAR
    public void atualizaPessoa(String cpf){
        try{
        Pessoa pessoa = MapeadorPessoa.getInstancia().get(cpf);
        telaAtualizaCadastro = new TelaAtualizaCadastro(pessoa);
        telaAtualizaCadastro.setVisible(true);
        } catch(Exception CadastroNaoEncontradoException){
           telaCadastroNaoEncontrado.setVisible(true);
        }     
    }
    
    public void cancelarPreenchimento(){
        telaCancelar.setVisible(true);
    }
    
    public void imprimeInformacoesPessoa(String cpf){
            TelaImprimeCadastroCidadao telaCadastroImprimir = 
                                     new TelaImprimeCadastroCidadao(cpf);
            telaCadastroImprimir.setVisible(true);
    }
    
    public void adicionaPessoa(Pessoa pessoa) throws Exception{
        String cpf = pessoa.getCpf();
        while(!validaCpf(cpf)){
            System.out.println("cpf EXISTE");
            throw new Exception();   
        }            
    }
    
    public void primeiraValidacaoPessoa(Pessoa pessoa)
            throws Exception, CadastroJahExisteException {
        String cpf = pessoa.getCpf();
        while(!validaCpf(cpf)){
            throw new Exception();   
        }
        if(!cpfJaCadastrado(cpf)){
           throw new CadastroJahExisteException();
        }          
    }   

    public void removePessoa(String cpf) {
        Pessoa pessoa = MapeadorPessoa.getInstancia().get(cpf);
        MapeadorPessoa.getInstancia().remove(pessoa); 
    }
    
    
    public Pessoa buscaPessoaCPF(String cpf) {
        try{
        Pessoa pessoa = MapeadorPessoa.getInstancia().get(cpf); 
        } catch(Exception CadastroNaoEncontradoException){
            System.out.println("CADASTRO NAO ENCONTRADO");
        }  
        return MapeadorPessoa.getInstancia().get(cpf);
    }
    
    public Pessoa buscaPessoaCPF1(String CPF)
            throws CadastroNaoEncontradoException{
        for(Pessoa pessoa: MapeadorPessoa.getInstancia().getList()){
            if(pessoa.getCpf().equals(CPF)){
                return pessoa;
            }
        }
        throw new CadastroNaoEncontradoException();
    }

    // VALIDACOES
    public boolean cpfJaCadastrado(String cpf) {
        for(Pessoa pessoa: MapeadorPessoa.getInstancia().getList()){
            if(pessoa.getCpf().equals(cpf)){
                return false;
            }
        }
        return true;
    }   
    public boolean validaCpf(String cpf) {
        return cpf.matches("[0-9]{11}"); 
    }
}
