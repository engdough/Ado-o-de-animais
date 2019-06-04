/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Exception.CadastroNaoEncontradoException;
import ufsc.br.ine5605.adocaoAnimais.Model.Animal;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IControladorAnimal {
    public void iniciaMenuAnimal();
    public void controlaMenu();
    public String pegaInfoOpcao();
    public void adicionaGato();
    public void adicionaCachorro();
    public void imprimeCadastroAnimal();
    public void imprimeRelatorioAnimaisCadastrados();
    public void removeAnimal();
    public void removeAnimalCodigo(String codigo);
    public boolean validaOpcao(String opcao);
    public String geraCodigo();
    public Animal buscaAnimalCodigo(String codigo) throws CadastroNaoEncontradoException;
}
