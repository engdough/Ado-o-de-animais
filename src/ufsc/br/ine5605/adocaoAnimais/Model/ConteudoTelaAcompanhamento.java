package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IConteudoTelaAcompanhamento;

public class ConteudoTelaAcompanhamento implements IConteudoTelaAcompanhamento, Serializable{
	String funcionario;
	Date data;
	ConteudoTelaFormularioAcompanhamento formulario;
	
	
    public ConteudoTelaAcompanhamento() {

    }

    public ConteudoTelaAcompanhamento(String funcionario, Date data, ConteudoTelaFormularioAcompanhamento formulario){
            this.funcionario = funcionario;
            this.data = data;
            this.formulario = formulario;
    }

    public ConteudoTelaFormularioAcompanhamento getFormulario() {
            return formulario;
    }

    public void setFormulario(ConteudoTelaFormularioAcompanhamento formulario) {
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


}
