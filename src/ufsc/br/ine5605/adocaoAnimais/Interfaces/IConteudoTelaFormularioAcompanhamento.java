package ufsc.br.ine5605.adocaoAnimais.Interfaces;

public interface IConteudoTelaFormularioAcompanhamento {
    public boolean isAnimalLimpo();
    public void setAnimalLimpo(boolean animalLimpo);
    public boolean isAnimalMagro();
    public void setAnimalMagro(boolean animalMagro);
    public boolean isAnimalFerido();
    public void setAnimalFerido(boolean animalFerido);
    public boolean isAnimalFoiVeterinario();
    public void setAnimalFoiVeterinario(boolean animalFoiVeterinario);
    public String getMotivoIdaVeterinario();
    public void setMotivoIdaVeterinario(String motivoIdaVeterinario);
    public boolean isAnimalMedicado() ;
    public void setAnimalMedicado(boolean animalMedicado);
    public String getQualMedicamento();
    public void setQualMedicamento(String qualMedicamento);
    public String getObs() ;
    public void setObs(String obs);

}
