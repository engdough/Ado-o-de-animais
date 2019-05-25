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
public interface IFormularioPessoal {
    
    public void setAdotouAntes(boolean adotouAntes);
    public void setTemQuintal(boolean temQuintal);
    public void setTemTempoPassear(boolean temTempoPassear);
    public void setTemOutrosAnimais(boolean temOutrosAnimais);
    public String getAdotouAntes();
    public String getTemQuintal();
    public String getTemTempoPassear();
    public String getTemOutrosAnimais();
}
