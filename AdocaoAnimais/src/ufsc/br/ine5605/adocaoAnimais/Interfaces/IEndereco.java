/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IEndereco {
    
    public void setCep(String Cep);
    public void setRua(String rua);
    public void setNumero(String numero);
    public void setBairro(String bairro);
    public void setCidade(String cidade);
    public void setEstado(String estado);
    public String getCep();
    public String getRua();
    public String getNumero();
    public String getBairro();
    public String getCidade();
    public String getEstado();
}
