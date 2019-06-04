/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Exception.RespostaInvalidaException;

/**
 *
 * @author Ana Elisa Kruger
 */

public interface ITelaAnimal {
    public String getCampo(String mensagem);
    public void mensagemErro(String mensagemErro);
    public void imprimeMensagem(String mensagem);
    public Idade getCampoIdade(String mensagem)throws RespostaInvalidaException;
    public Porte getCampoPorte(String mensagem)throws RespostaInvalidaException;
    public Sexo getCampoSexo(String mensagem) throws RespostaInvalidaException;
    public boolean getCampoBoolean(String mensagem)
                               throws RespostaInvalidaException;
}
