package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IAcompanhamento;

public class Acompanhamento implements IAcompanhamento, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String funcionario;
	private Date data;
	private FormularioAcompanhamento formulario;
	
	
	public Acompanhamento(String funcionario, Date data, FormularioAcompanhamento formulario) {
		this.funcionario = funcionario;
		this.data = data;
		this.formulario = formulario;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public FormularioAcompanhamento getFormulario() {
		return this.formulario;
	}
	
	
	public void setFormulario(FormularioAcompanhamento formulario) {
		this.formulario = formulario;
	}
}