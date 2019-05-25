package ufsc.br.ine5605.adocaoAnimais.Model;
import java.io.Serializable;

import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Model.Animal;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Enum.Tipo;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.ICachorro;

/**
 *
 * @author Ana Elisa Kruger
 */
public class Cachorro extends Animal implements ICachorro, Serializable{
    private String raca;
    private Tipo tipo = Tipo.CACHORRO;
    
    public Cachorro(){
        super.setTipo(this.tipo);
    }

    public Cachorro(String raca,
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
        this.raca = raca;
    }
           
    public void setRacaCachorro(String raca){
        this.raca = raca;
    }
    
    public String getRacaCachorro(){
        return this.raca;
    }
}