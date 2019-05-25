/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import java.util.ArrayList;
import ufsc.br.ine5605.adocaoAnimais.Model.Acompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.Adocao;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAcompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAdocao;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaFormularioAcompanhamento;


public interface IControladorAdocao {
    
    public void mostraMenuAdocao();
    public void executaMenuAdocao(String opcao);
    public void adicionaAdocao(ConteudoTelaAdocao conteudoTelaAdocao);
    public Adocao desempacotaAdocao(ConteudoTelaAdocao conteudoTelaAdocao);
    public ConteudoTelaAdocao empacotaAdocao(Adocao adocao);
    public void adicionaAcompanhamento(ConteudoTelaAcompanhamento conteudoTelaAcompanhamento, ConteudoTelaFormularioAcompanhamento conteudoTelaFormulario, int codigoAdocao); 
    public Acompanhamento desempacotaAcompanhamento(ConteudoTelaAcompanhamento conteudoTelaAcompanhamento, ConteudoTelaFormularioAcompanhamento conteudoTelaFormulario);
    public ConteudoTelaAcompanhamento empacotaAcompanhamento(Acompanhamento acompanhamento);
    public Adocao buscaAdocao(int codigoAdocao);
    public void excluirAdocao(int codigoAdocao);
    public void listaAdocoes();
    public ArrayList<ConteudoTelaAcompanhamento> listagemAcompanhamento(int codigoAdocao);
    public int geraCodigo(); 
    public boolean codigoValido(String codigo);
    
}
