/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.Mapeadores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import ufsc.br.ine5605.adocaoAnimais.Model.Animal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class MapeadorAnimal {
    
    private HashMap<String, Animal> cacheAnimais = new HashMap<>();
    private final String filename = "animal.dados";
    private static MapeadorAnimal instancia;
    
    
    public MapeadorAnimal(){
        load();
    }
    
    public static MapeadorAnimal getInstancia(){
        if (instancia == null){
        instancia = new MapeadorAnimal();
        } 
        return instancia;
    } 
    
    public Animal get(String cpf){
        load();
        return cacheAnimais.get(cpf); 
    }
    
    public void put(Animal animal){
        cacheAnimais.put(animal.getCodigo(), animal);
        persist();
    }
        
    public void persist(){
        try{    
            FileOutputStream fileOutput = new FileOutputStream(filename);
            
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheAnimais);
            
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
           
           this.cacheAnimais = (HashMap<String, Animal>) objectImput.readObject();
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
    
    public Collection<Animal> getList(){
        load();
        return cacheAnimais.values();
    
    }
    
    public void removeCodigo(String codigo){
        cacheAnimais.remove(codigo);
        persist();
    }
    
    public void remove(Animal animal){
        cacheAnimais.remove(animal.getCodigo());
        persist();
    }
    
}
