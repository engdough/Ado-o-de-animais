package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IAdocao;

public class Adocao implements IAdocao, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private Animal animal;
	private Pessoa pessoa;
	private Date data;
	private ArrayList<Acompanhamento> acompanhamentos;
	
	public Adocao(int codigo, Animal animal, Pessoa pessoa, Date data){
		this.codigo = codigo;
		this.animal = animal;
		this.pessoa = pessoa;
		this.data = data;
		this.acompanhamentos = new ArrayList<>();
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public ArrayList<Acompanhamento> getAcompanhamento(){
		return acompanhamentos;
	}
	
	public void inserirAcompanhamento(Acompanhamento acompanhamento) {
		acompanhamentos.add(acompanhamento);
	}
	
}