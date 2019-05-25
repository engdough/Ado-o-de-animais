package ufsc.br.ine5605.adocaoAnimais.Model;
import java.io.Serializable;

import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Enum.Tipo;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IAnimal;
/**
 *
 * @author Ana Elisa Kruger
 */
public abstract class Animal implements IAnimal, Serializable{
    private String codigo;
    private String peso;
    private Idade idade;
    private Porte porte;
    private boolean foiCastrado;
    private boolean apresentaDeficiencia;
    private Sexo sexo;
    private Tipo tipo;

    public Animal(String codigo, 
            String peso, 
            Idade idade, 
            Porte porte, 
            boolean foiCastrado, 
            boolean apresentaDeficiencia,
            Sexo sexo, 
            Tipo tipo) {
        
        this.codigo = codigo;
        this.peso = peso;
        this.idade = idade;
        this.porte = porte;
        this.foiCastrado = foiCastrado;
        this.apresentaDeficiencia = apresentaDeficiencia;
        this.sexo = sexo;
        this.tipo = tipo;
    }
    
    public Animal(){
    
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPeso() {
        return peso;
    }

    public Idade getIdade() {
        return idade;
    }

    public Porte getPorte() {
        return porte;
    }

    public String getFoiCastrado() {
        if(foiCastrado){
            return "SIM";
        }
        return "NAO";
    }

    public String getApresentaDeficiencia() {
        if(apresentaDeficiencia){
            return "SIM";
        }
        return "NAO";
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
     public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setIdade(Idade idade) {
        this.idade = idade;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public void setFoiCastrado(boolean foiCastrado) {
        this.foiCastrado = foiCastrado;
    }

    public void setApresentaDeficiencia(boolean apresentaDeficiencia) {
        this.apresentaDeficiencia = apresentaDeficiencia;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
