package ufsc.br.ine5605.adocaoAnimais.Controller;
import java.util.Scanner;

import ufsc.br.ine5605.adocaoAnimais.Interfaces.IControladorPrincipal;
import ufsc.br.ine5605.adocaoAnimais.View.TelaPrincipal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class ControladorPrincipal implements IControladorPrincipal{
    private TelaPrincipal telaPrincipal;
    private final ControladorAnimal controladorAnimal;
    private ControladorAdocao controladorAdocao;
    private static ControladorPrincipal instancia;

    public ControladorPrincipal() {

            controladorAnimal = new ControladorAnimal();
            controladorAdocao = new ControladorAdocao(this, controladorAnimal);
    }
    public static ControladorPrincipal getInstancia(){
    if (instancia == null){
    instancia = new ControladorPrincipal();
    } 
    return instancia;
    }

    public void iniciaSistema() {
    	telaPrincipal = new TelaPrincipal(this);
    }
    
    public void controlaMenu(String opcao) {
    	if(opcao.contains("1")){
           ControladorPessoa.getInstancia().iniciaMenuPessoa();
        } else if (opcao.contains("2")){
            controladorAnimal.iniciaMenuAnimal();

        } else if (opcao.contains("3")){
            controladorAdocao.mostraMenuAdocao();
             
        }
    }
     
}
