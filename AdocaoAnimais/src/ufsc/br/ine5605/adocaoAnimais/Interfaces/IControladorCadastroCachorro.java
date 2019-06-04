package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Model.Cachorro;

/**
 *
 * @author Ana Elisa Kruger
 */
public interface IControladorCadastroCachorro {
    public Cachorro pegaInformacoesTela(String codigoAnimal);
    public void pegaInfoSexo();    
    public void pegaInfoIdade();    
    public void pegaInfoPorte();
    public void pegaInfoPeso();     
    public void pegaInfoApresentaDeficiencia();    
    public Porte validaPorte(String mensagem);
    public Sexo validaSexo(String mensagem);    
    public boolean pegaInfoBooleana(String mensagem);
}
