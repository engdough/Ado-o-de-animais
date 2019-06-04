package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IEndereco;

/**
 *
 * @author Ana Elisa Kruger
 */
public class Endereco implements IEndereco, Serializable{

    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String cep,
            String rua,
            String numero,
            String bairro,
            String cidade,
            String estado) {
        
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco(){

    }

    public void setCep(String Cep){
        this.cep = Cep;
    }

    public void setRua(String rua){
        this.rua = rua;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getCep(){
        return this.cep;
    }
    public String getRua(){
        return this.rua;
    }
    public String getNumero(){
        return this.numero;
    }
    public String getBairro(){
        return this.bairro;
    }
    public String getCidade(){
        return this.cidade;
    }
    public String getEstado(){
        return this.estado;
    }
}
