package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;

import ufsc.br.ine5605.adocaoAnimais.Interfaces.IConteudoTelaFormularioAcompanhamento;

public class ConteudoTelaFormularioAcompanhamento implements IConteudoTelaFormularioAcompanhamento, Serializable {
	boolean animalLimpo;
	boolean animalMagro;
	boolean animalFerido;
	boolean animalFoiVeterinario;
	String motivoIdaVeterinario;
	boolean animalMedicado;
	String qualMedicamento;
	String obs;
	
    public ConteudoTelaFormularioAcompanhamento() {

    }

    public ConteudoTelaFormularioAcompanhamento(boolean animalLimpo, boolean animalMagro, boolean animalFerido, boolean animalFoiVeterinario, String motivoIdaVeterinario, boolean animalMedicado, String qualMedicamento, String obs){
            this.animalLimpo = animalLimpo;
            this.animalMagro = animalMagro;
            this.animalFerido = animalFerido;
            this.animalFoiVeterinario = animalFoiVeterinario;
            this.motivoIdaVeterinario = motivoIdaVeterinario;
            this.animalMedicado = animalMedicado;
            this.qualMedicamento = qualMedicamento;
            this.obs = obs;
    }

    public boolean isAnimalLimpo() {
            return animalLimpo;
    }

    public void setAnimalLimpo(boolean animalLimpo) {
            this.animalLimpo = animalLimpo;
    }

    public boolean isAnimalMagro() {
            return animalMagro;
    }

    public void setAnimalMagro(boolean animalMagro) {
            this.animalMagro = animalMagro;
    }

    public boolean isAnimalFerido() {
            return animalFerido;
    }

    public void setAnimalFerido(boolean animalFerido) {
            this.animalFerido = animalFerido;
    }

    public boolean isAnimalFoiVeterinario() {
            return animalFoiVeterinario;
    }

    public void setAnimalFoiVeterinario(boolean animalFoiVeterinario) {
            this.animalFoiVeterinario = animalFoiVeterinario;
    }

    public String getMotivoIdaVeterinario() {
            return motivoIdaVeterinario;
    }

    public void setMotivoIdaVeterinario(String motivoIdaVeterinario) {
            this.motivoIdaVeterinario = motivoIdaVeterinario;
    }

    public boolean isAnimalMedicado() {
            return animalMedicado;
    }

    public void setAnimalMedicado(boolean animalMedicado) {
            this.animalMedicado = animalMedicado;
    }

    public String getQualMedicamento() {
            return qualMedicamento;
    }

    public void setQualMedicamento(String qualMedicamento) {
            this.qualMedicamento = qualMedicamento;
    }

    public String getObs() {
            return obs;
    }

    public void setObs(String obs) {
            this.obs = obs;
    }

}