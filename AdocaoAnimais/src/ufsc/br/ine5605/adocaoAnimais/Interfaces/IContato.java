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
public interface IContato {
   
    public void setEmail(String email);
    public void setTelefoneCelular(String telefoneCelular);
    public void setTelefoneFixo(String telefoneFixo);
    public String getEmail();
    public String getTelefoneCelular();
    public String getTelefoneFixo();
}
