package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IConteudoTelaAdocao;

public class ConteudoTelaAdocao implements IConteudoTelaAdocao, Serializable{
	int codigo;
	Animal animal;
	Pessoa pessoa;
	Date data;
	ArrayList<Acompanhamento> acompanhamentos;
	
    public ConteudoTelaAdocao() {
    }

    public ConteudoTelaAdocao(int codigo, Animal animal, Pessoa pessoa, Date data, ArrayList<Acompanhamento> acompanhamentos){
            this.codigo = codigo;
            this.animal = animal;
            this.pessoa = pessoa;
            this.data = data;
            this.acompanhamentos = acompanhamentos;
    }

    public int getCodigo() {
            return this.codigo;
    }

    public void setCodigo(int codigo) {
            this.codigo = codigo;
    }

    public Animal getAnimal() {
            return animal;
    }

    public void setAnimal(Animal animal) {
            this.animal = animal;
    }

    public Pessoa getPessoa() {
            return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
    }

    public Date getData() {
            return data;
    }

    public void setData(Date data) {
            this.data = data;
    }

    public ArrayList<Acompanhamento> getAcompanhamento(){
            return this.acompanhamentos;
    }

}