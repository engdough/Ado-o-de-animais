/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Interfaces;

import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Model.FormularioAcompanhamento;

public interface IAcompanhamento {
   
    public String getFuncionario();
    public void setFuncionario(String funcionario);
    public Date getData();
    public void setData(Date data);
    public FormularioAcompanhamento getFormulario();
    public void setFormulario(FormularioAcompanhamento formulario) ;
}
