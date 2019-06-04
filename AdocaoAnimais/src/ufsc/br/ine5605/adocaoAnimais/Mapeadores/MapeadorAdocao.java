package ufsc.br.ine5605.adocaoAnimais.Mapeadores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import ufsc.br.ine5605.adocaoAnimais.Model.Adocao;

public class MapeadorAdocao {
	private HashMap<String, Adocao> cacheAdocao = new HashMap<>();
	private final String filename = "adocao.dados";
	
	public MapeadorAdocao() {
		load();
	}
	
	public Adocao get(String codigo) {
		return cacheAdocao.get(codigo);
	}
	
	public void put (Adocao adocao) {
		cacheAdocao.put(Integer.toString(adocao.getCodigo()), adocao);
		persist();
	}
	
	public void persist() {
		try{
	        
            FileOutputStream fileOutput = new FileOutputStream(filename);
            
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(cacheAdocao);
            
            objectOutput.flush();
            fileOutput.flush();
            
            objectOutput.close();
            fileOutput.close();
        } catch (FileNotFoundException ex){
            System.out.println("ARQUIVO NÃO ENCONTRADO");
        } catch (IOException ex){
            System.out.println("ERRO AO ABRIR O ARQUIVO");
        }
	}
	
	public void load() {
		try{
	           FileInputStream fileImput = new FileInputStream(filename);
	           ObjectInputStream  objectImput = new ObjectInputStream(fileImput);
	           
	           this.cacheAdocao = (HashMap<String, Adocao>) objectImput.readObject();
	           objectImput.close();
	           fileImput.close();
	        } catch (ClassNotFoundException ex){
	            System.out.println("ERRO AO ABRIR O ARQUIVO");
	        } catch (FileNotFoundException ex){
	            System.out.println("ARQUIVO NÃO ENCONTRADO");
	            persist();
	        } catch (IOException ex){
	            System.out.println("ERRO AO ABRIR O ARQUIVO");
	        }
	}
	
	public Collection<Adocao> getList(){
		return cacheAdocao.values();
	}
	
	public void remove(Adocao adocao) {
		cacheAdocao.remove(Integer.toString(adocao.getCodigo()));
		persist();
	}
	
	public boolean listaVazia() {
		return cacheAdocao.isEmpty();
	}
	
	public int tamanhoLista() {
		return cacheAdocao.size();
	}

}
