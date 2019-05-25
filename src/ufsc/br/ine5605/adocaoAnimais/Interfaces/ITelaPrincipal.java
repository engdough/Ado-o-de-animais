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
public interface ITelaPrincipal {
    
    public void imprimeMensagem(String mensagem);
    public void encerraSistema();
    public String getCampo(String mensagem);
    public void mensagemErro(String mensagem);
}
