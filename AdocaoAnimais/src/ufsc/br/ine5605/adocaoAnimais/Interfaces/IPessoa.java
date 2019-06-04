/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Model.Contato;
import ufsc.br.ine5605.adocaoAnimais.Model.Endereco;
import ufsc.br.ine5605.adocaoAnimais.Model.FormularioPessoal;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IPessoa {
    
    public void setCPF(String cpf);
    public void setNome(String nome);
    public void setIdade(String idade);
    public void setEndereco(Endereco endereco);
    public void setContato(Contato contato);
    public void setFormularioPessoal(FormularioPessoal formularioPessoal) ;
    public String getCpf();
    public String getNome();
    public String getIdade();
    public Endereco getEndereco();
    public Contato getContato();
    public FormularioPessoal getFormularioPessoal() ;
}
