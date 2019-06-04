package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IPessoa;
import ufsc.br.ine5605.adocaoAnimais.Model.Contato;

/**
 *
 * @author Ana Elisa Kruger
 */

public class Pessoa implements IPessoa, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String cpf;
    private String nome;
    private String idade;
    private Endereco endereco;
    private Contato contato;
    private FormularioPessoal formularioPessoal = new FormularioPessoal();

    public Pessoa(String cpf, String nome, String idade, Endereco endereco,
            Contato contato, FormularioPessoal formularioPessoal){
        
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.contato = contato;
        this.formularioPessoal = formularioPessoal;
        
    }
    
    public Pessoa(){
    
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setIdade(String idade){
        this.idade = idade;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public void setContato(Contato contato){
        this.contato = contato;
    }

    public void setFormularioPessoal(FormularioPessoal formularioPessoal) {
        this.formularioPessoal = formularioPessoal;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public String getIdade(){
        return this.idade;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public Contato getContato(){
        return this.contato;
    }

    public FormularioPessoal getFormularioPessoal() {
        return formularioPessoal;
    }  
}

