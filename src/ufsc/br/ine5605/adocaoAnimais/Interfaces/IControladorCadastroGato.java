/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Model.Gato;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IControladorCadastroGato {
    public Gato pegaInformacoesTela(String codigoAnimal);
    public void pegaInfoSexo();    
    public void pegaInfoIdade();    
    public void pegaInfoPorte();
    public void pegaInfoPeso();     
    public void pegaInfoApresentaDeficiencia();    
    public Porte validaPorte(String mensagem);
    public Sexo validaSexo(String mensagem);    
    public boolean pegaInfoBooleana(String mensagem);}
