package ufsc.br.ine5605.adocaoAnimais.Controller;
import java.util.ArrayList;
import java.util.Collection;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroCachorro;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorCadastroGato;
import ufsc.br.ine5605.adocaoAnimais.Enum.Tipo;
import ufsc.br.ine5605.adocaoAnimais.Exception.CadastroNaoEncontradoException;
import ufsc.br.ine5605.adocaoAnimais.Model.Animal;
import ufsc.br.ine5605.adocaoAnimais.Model.Cachorro;
import ufsc.br.ine5605.adocaoAnimais.Model.Gato;
import ufsc.br.ine5605.adocaoAnimais.View.TelaAnimal;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IControladorAnimal;
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorAnimal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class ControladorAnimal implements IControladorAnimal {
    private final TelaAnimal telaAnimal = new TelaAnimal();
    private static ControladorAnimal instancia;   
    
     public static ControladorAnimal getInstancia(){
        if (instancia == null){
        instancia = new ControladorAnimal();
        } 
        return instancia;
    }
    
    //INICIA MENU PESSOAS
    public void iniciaMenuAnimal() {
        telaAnimal.imprimeMensagem("\n -------- MENU DO CADASTRO " +
            "DE ANIMAIS -------- \n");
        controlaMenu();
    }
    
    //DIRECIONAMENTO OPCOES
    public void controlaMenu() {
        String opcao = pegaInfoOpcao();
        if(opcao.contains("1")){
           this.adicionaCachorro();
           iniciaMenuAnimal();
        } else if (opcao.contains("2")){
            this.adicionaGato();
            iniciaMenuAnimal();
        } else if (opcao.contains("3")){
            this.removeAnimal();
            iniciaMenuAnimal();
        }else if (opcao.contains("4")){
            this.imprimeCadastroAnimal();
            iniciaMenuAnimal();
        } else if (opcao.contains("5")){
           this.imprimeRelatorioAnimaisCadastrados();
           iniciaMenuAnimal();
        } else if (opcao.contains("6")){
            ControladorPrincipal.getInstancia().iniciaSistema();;
        }
    }
    
    // PEGA INFORMACOES DE OPCAO SELECIONADA DA TELA
    public String pegaInfoOpcao(){
        String opcao = this.telaAnimal.getCampo("Selecione uma das " +
            "opcoes abaixo: \n" +
        "1 - CADASTRAR CACHORRO. \n" +
        "2 - CADASTRAR GATO. \n" +
        "3 - REMOVER CADASTRO \n" +
        "4 - IMPRIMIR INFORMACOES ANIMAL \n" +
        "5 - IMPRIMIR RELATORIO DE CADASTROS ANIMAIS\n" +
        "6 - VOLTAR MENU PRINCIPAL \n");
        
        while(!validaOpcao(opcao)){
            telaAnimal.mensagemErro("Opcao Invalida! Por favor digite" +
                    " apenas o numero equivalente a opcao desejada \n");
            opcao = this.telaAnimal.getCampo("Selecione uma das " +
            "opcoes abaixo: \n" +
        "1 - CADASTRAR CACHORRO. \n" +
        "2 - CADASTRAR GATO. \n" +
        "3 - REMOVER CADASTRO \n" +
        "4 - IMPRIMIR INFORMACOES ANIMAL \n" +
        "5 - IMPRIMIR RELATORIO DE CADASTROS ANIMAIS\n" +
        "6 - VOLTAR MENU PRINCIPAL \n");
        } 
        return opcao;
    }

    public void adicionaGato(){
        ControladorCadastroGato controladorCadastroGato = 
                            new ControladorCadastroGato();
        MapeadorAnimal.getInstancia().put(controladorCadastroGato.pegaInformacoesTela(geraCodigo()));
        telaAnimal.imprimeMensagem("\n     >>>> GATO CADASTRADO COM " +
            "SUCESSO!! <<<< \n");
    }    

    public void adicionaCachorro() {
        ControladorCadastroCachorro controladorCadastroCachorro = 
                                new ControladorCadastroCachorro();
        MapeadorAnimal.getInstancia().put(
                controladorCadastroCachorro.pegaInformacoesTela(geraCodigo()));
        telaAnimal.imprimeMensagem("\n     >>>> CACHORRO CADASTRADO COM " +
            "SUCESSO!! <<<< \n");
    }

    public void imprimeCadastroAnimal() {
        String codigo = this.telaAnimal.getCampo("Informe o codigo do ANIMAL");
        try{
        Animal animal = buscaAnimalCodigo(codigo);
        telaAnimal.imprimeMensagem(" \n ------ INFORMACOES ANIMAL ------");
        telaAnimal.imprimeMensagem("Tipo: " + animal.getTipo());
        telaAnimal.imprimeMensagem("Codigo: " + animal.getCodigo());
        telaAnimal.imprimeMensagem("Peso: " + animal.getPeso());
        telaAnimal.imprimeMensagem("Idade: " + animal.getIdade());
        telaAnimal.imprimeMensagem("Porte: " + animal.getPorte());
        telaAnimal.imprimeMensagem("Sexo: " + animal.getSexo());
        if(animal.getTipo().equals(Tipo.CACHORRO)){
            Cachorro cachorro = (Cachorro) animal;
        telaAnimal.imprimeMensagem("Raca: " + 
                        cachorro.getRacaCachorro());
        }else if(animal.getTipo().equals(Tipo.GATO)){
            Gato gato= (Gato) animal;
        telaAnimal.imprimeMensagem("Raca: " + 
                        gato.getRacaGato());
        
        }
        telaAnimal.imprimeMensagem("\n O Animal foi castrado?: \n" +
               "> Resposta: " + animal.getFoiCastrado() + "\n");
        telaAnimal.imprimeMensagem("O Animal apresenta Deficiencia?: \n" +
               "> Resposta: " + animal.getApresentaDeficiencia() + "\n");
        } catch(Exception CadastroNaoEncontradoException){
            telaAnimal.imprimeMensagem(" ANIMAL NAO ENCONTRADO");
        }
    }

    public void imprimeRelatorioAnimaisCadastrados() {
        int i = 1;
        telaAnimal.imprimeMensagem(" \n ----- RELATORIO DE CADASTROS " +
                "DE ANIMAIS ----- \n");
        if(MapeadorAnimal.getInstancia().getList().isEmpty()){
                telaAnimal.imprimeMensagem(" \n NENHUM ANIMAL CADASTRADO!" +
                " Cadastre atraves do MENU.");
        } else{
            for(Animal animal: MapeadorAnimal.getInstancia().getList()){
                telaAnimal.imprimeMensagem(i + ". > Codigo: " +
                   animal.getCodigo() +
                   "  > Tipo: " + animal.getTipo() + 
                   "  > Sexo: " + animal.getSexo() + 
                   "  > Idade: " + animal.getIdade() );
                i++;
            }
        }
    }

    public void removeAnimal() {
        try{
        String codigo = this.telaAnimal.getCampo("Informe o CODIGO do Animal");
        Animal animal = buscaAnimalCodigo(codigo);
        telaAnimal.imprimeMensagem(" \n    >>>> ANIMAL REMOVIDO COM SUCESSO!!" +
            " <<<< \n");
        MapeadorAnimal.getInstancia().remove(animal);
        } catch(Exception CadastroNaoEncontradoException){
            telaAnimal.imprimeMensagem(" \n Nao foi possivel remover " +
                    "o cadastro, pois o animal nao esta registrado! \n");
        }  
    }
    
    public void removeAnimalCodigo(String codigo) {
        try{
        Animal animal = buscaAnimalCodigo(codigo);
        MapeadorAnimal.getInstancia().remove(animal);
        } catch(Exception CadastroNaoEncontradoException){
            telaAnimal.imprimeMensagem(" \n Nao foi possivel remover " +
                    "o cadastro, pois o animal nao esta registrado! \n");
        }  
    }

    public boolean validaOpcao(String opcao) {
        return opcao.matches("[1-6]{1}"); 
    }
    
    public String geraCodigo(){
        Collection animais = MapeadorAnimal.getInstancia().getList();  
        int codigoNumerico = animais.size() +1;
        String codigoAnimal = String.valueOf(codigoNumerico);   
        return codigoAnimal;  
    }

    public Animal buscaAnimalCodigo(String codigo) 
                        throws CadastroNaoEncontradoException{
        for(Animal animal: MapeadorAnimal.getInstancia().getList()){
            if(animal.getCodigo().equals(codigo)){
                return animal;
            }
        }
        throw new CadastroNaoEncontradoException();
    }

}
