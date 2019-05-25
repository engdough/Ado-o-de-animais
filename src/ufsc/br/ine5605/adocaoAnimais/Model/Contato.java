package ufsc.br.ine5605.adocaoAnimais.Model;

import java.io.Serializable;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IContato;

/**
 *
 * @author Ana Elisa Kruger
 */
public class Contato implements IContato, Serializable{
    private String email;
    private String telefoneCelular;
    private String telefoneFixo;

    public Contato() {
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }  
}
