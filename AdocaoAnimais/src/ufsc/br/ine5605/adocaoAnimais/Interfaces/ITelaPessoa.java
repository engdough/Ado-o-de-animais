/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Exception.RespostaInvalidaException;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface ITelaPessoa {
    public void imprimeMensagem(String mensagem);
    public String getCampo(String mensagem);
    public void mensagemErro(String mensagemErro);
    public boolean getCampoBoolean(String mensagem) 
                            throws RespostaInvalidaException;
}
