/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;

import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Enum.Tipo;
import ufsc.br.ine5605.adocaoAnimais.Model.Animal;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IGato;

/**
 *
 * @author Ana Elisa Kruger
 */
public class Gato extends Animal implements IGato, Serializable{
    private String racaGato;
    private Tipo tipo = Tipo.GATO;
    
    public Gato(){
        super.setTipo(this.tipo);
    }

    public Gato(String racaGato, 
            String codigo, 
            String peso, 
            Idade idade,
            Porte porte,
            boolean foiCastrado, 
            boolean apresentaDeficiencia, 
            Sexo sexo, 
            Tipo tipo) {
        
        super(codigo, peso, idade, porte, foiCastrado, 
                    apresentaDeficiencia, sexo, tipo);
        this.racaGato = racaGato;
    }
    
    public void setRacaGato(String raca){
        this.racaGato = racaGato;
    }
    
    public String getRacaGato(){
        return this.racaGato;
    }
}
