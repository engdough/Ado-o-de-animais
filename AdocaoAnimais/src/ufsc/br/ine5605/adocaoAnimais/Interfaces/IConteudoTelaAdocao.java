package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Model.Acompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.Animal;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

public interface IConteudoTelaAdocao {
   
    public int getCodigo();
    public void setCodigo(int codigo);
    public Animal getAnimal() ;
    public void setAnimal(Animal animal);
    public Pessoa getPessoa();
    public void setPessoa(Pessoa pessoa);
    public Date getData();
    public void setData(Date data);
    public ArrayList<Acompanhamento> getAcompanhamento();
}
