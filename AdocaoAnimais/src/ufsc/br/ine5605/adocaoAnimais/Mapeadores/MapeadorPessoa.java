package ufsc.br.ine5605.adocaoAnimais.Mapeadores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;

/**
 *
 * @author 08971976900
 */
public class MapeadorPessoa {
    
    private HashMap<String, Pessoa> cachePessoas2 = new HashMap<>();
    private final String filename = "pessoas.dados";
    private static MapeadorPessoa instancia;
    
    public MapeadorPessoa(){
        load();
//        cachePessoas.clear();
    }
    
    public static MapeadorPessoa getInstancia(){
        if (instancia == null){
        instancia = new MapeadorPessoa();
        } 
        return instancia;
    } 
    
    public Pessoa get(String cpf){
        load();
        return cachePessoas2.get(cpf); 
    }
    
    public void put(Pessoa pessoa){
        cachePessoas2.put(pessoa.getCpf(), pessoa);
        persist();
    }
    
    
    public void persist(){
        try{    
            FileOutputStream fileOutput = new FileOutputStream(filename);
            
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cachePessoas2);
            
            objectOutput.flush();
            fileOutput.flush();
            
            objectOutput.close();
            fileOutput.close();
        } catch (FileNotFoundException ex){
            System.out.println("ARQUIVO NAO ENCONTRADO");
        } catch (IOException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        }
    }
    
    public void load() {
        try{
           FileInputStream fileImput = new FileInputStream(filename);
           ObjectInputStream  objectImput = new ObjectInputStream(fileImput);
           
           this.cachePessoas2 = (HashMap<String, Pessoa>) objectImput.readObject();
           objectImput.close();
           fileImput.close();
        } catch (ClassNotFoundException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        } catch (FileNotFoundException ex){
            System.out.println("ARQUIVO NAO ENCONTRADO");
            persist();
        } catch (IOException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        }
    }
    
    public Collection<Pessoa> getList(){
        load();
        return cachePessoas2.values();
    
    }
    
    public void removeCpf(String cpf){
        cachePessoas2.remove(cpf);
        persist();
    }
    
    public void remove(Pessoa pessoa){
        cachePessoas2.remove(pessoa.getCpf());
        persist();
    }
}
