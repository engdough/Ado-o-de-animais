package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaFormularioAcompanhamento;

public interface IConteudoTelaAcompanhamento {
 
    public ConteudoTelaFormularioAcompanhamento getFormulario();
    public void setFormulario(ConteudoTelaFormularioAcompanhamento formulario);
    public String getFuncionario();
    public void setFuncionario(String funcionario) ;
    public Date getData();
    public void setData(Date data);
}
