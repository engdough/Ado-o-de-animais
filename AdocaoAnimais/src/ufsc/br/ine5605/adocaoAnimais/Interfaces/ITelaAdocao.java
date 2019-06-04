/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import java.util.ArrayList;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAdocao;

public interface ITelaAdocao {
    
    public void mostraMenuAdocao();
    public void mostrarTelaNovaAdocao();
    public void mostrarTelaAcompanhamento();
    public void mostrarTelaExclusao();
    public void mostrarListaAdocoes(ArrayList<ConteudoTelaAdocao> listaAdocoes);
    public void mostraListaAcompanhamentos();
    public boolean getCampoBoolean(String mensagem);
    public String getMensagemSimNao(boolean mensagem);
    public void encerraMenuAdocao();
}
