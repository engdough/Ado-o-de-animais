package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Enum.Tipo;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IAnimal {
    
    public String getCodigo();
    public String getPeso();
    public Idade getIdade();
    public Porte getPorte();
    public String getFoiCastrado();
    public String getApresentaDeficiencia();
    public Sexo getSexo();
    public Tipo getTipo();
    public void setTipo(Tipo tipo);
    public void setCodigo(String codigo);
    public void setPeso(String peso);
    public void setIdade(Idade idade);
    public void setPorte(Porte porte);
    public void setFoiCastrado(boolean foiCastrado);
    public void setApresentaDeficiencia(boolean apresentaDeficiencia);
    public void setSexo(Sexo sexo);
}    
