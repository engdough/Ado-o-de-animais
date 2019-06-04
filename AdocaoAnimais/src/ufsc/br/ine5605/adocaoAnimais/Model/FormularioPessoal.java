package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IFormularioPessoal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class FormularioPessoal implements IFormularioPessoal, Serializable{
    
   private boolean adotouAntes;
   private boolean temQuintal;
   private boolean temTempoPassear;
   private boolean temOutrosAnimais;

    public void setAdotouAntes(boolean adotouAntes) {
        this.adotouAntes = adotouAntes;
    }

    public void setTemQuintal(boolean temQuintal) {
        this.temQuintal = temQuintal;
    }

    public void setTemTempoPassear(boolean temTempoPassear) {
        this.temTempoPassear = temTempoPassear;
    }

    public void setTemOutrosAnimais(boolean temOutrosAnimais) {
        this.temOutrosAnimais = temOutrosAnimais;
    }

    public String getAdotouAntes() {
        if(adotouAntes){
            return "Sim";
        }
        return "Nao";
    }

    public String getTemQuintal() {
        if(temQuintal){
            return "Sim";
        }
        return "Nao";
    }

    public String getTemTempoPassear() {
        if(temTempoPassear){
            return "Sim";
        }
        return "Nao";
    }

    public String getTemOutrosAnimais() {
        if(temOutrosAnimais){
            return "Sim";
        }
        return "Nao";
    }
}
