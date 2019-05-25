package ufsc.br.ine5605.adocaoAnimais.View;
import java.util.Scanner;
import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Exception.RespostaInvalidaException;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.ITelaAnimal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaAnimal implements ITelaAnimal{
        Scanner sc = new Scanner(System.in);
         
    public String getCampo(String mensagem) {
        System.out.println(mensagem);
        String conteudoCampo = sc.nextLine();
        return conteudoCampo;
    }

    public void mensagemErro(String mensagemErro) {
        System.out.println(mensagemErro);
    }
    
    public void imprimeMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public Idade getCampoIdade(String mensagem)
                    throws RespostaInvalidaException{
        System.out.println(mensagem);
        String conteudoCampo = sc.nextLine();
        
        if(!conteudoCampo.toUpperCase().contains("FILHOTE") 
                && !conteudoCampo.toUpperCase().contains("ADULTO")
                && !conteudoCampo.toUpperCase().contains("VELHO")){
            throw new RespostaInvalidaException("\nRESPOSTA INCORRETA! " +
                    "Por favor responda apenas com uma das" +
                    " opções apresentadas!\n");
        }else if (conteudoCampo.toUpperCase().contains("FILHOTE")){
                return Idade.FILHOTE;
        } else if(conteudoCampo.toUpperCase().contains("ADULTO")){
            return  Idade.ADULTO;
        }
            return Idade.VELHO;
    }

    public Porte getCampoPorte(String mensagem)throws RespostaInvalidaException{
        System.out.println(mensagem);
        String conteudoCampo = sc.nextLine();
        
        if(!conteudoCampo.toUpperCase().contains("PEQUENO") 
                && !conteudoCampo.toUpperCase().contains("MEDIO")
                && !conteudoCampo.toUpperCase().contains("GRANDE")){
            throw new RespostaInvalidaException("\nRESPOSTA INCORRETA! " +
                    "Por favor responda apenas com uma das" +
                    " opções apresentadas!\n");
        }else if (conteudoCampo.toUpperCase().contains("PEQUENO")){
            return Porte.PEQUENO;
        } else if(conteudoCampo.toUpperCase().contains("MEDIO")){
            return Porte.MEDIO;
        }
            return Porte.GRANDE;
    }

    public Sexo getCampoSexo(String mensagem) throws RespostaInvalidaException{
        System.out.println(mensagem);
        String conteudoCampo = sc.nextLine();
 
        if(!conteudoCampo.toUpperCase().contains("FEMEA") 
                && !conteudoCampo.toUpperCase().contains("MACHO") ){
            throw new RespostaInvalidaException("\nRESPOSTA INCORRETA! " +
                    "Por favor responda apenas com uma das" +
                    " opções apresentadas!\n");
        }else if (conteudoCampo.toUpperCase().contains("FEMEA")){
            return  Sexo.FEMEA;
        }
            return Sexo.MACHO;
    }
    
    public boolean getCampoBoolean(String mensagem)
                        throws RespostaInvalidaException{
        System.out.println(mensagem);
        String conteudoCampo = sc.nextLine();
        
        if(!conteudoCampo.toUpperCase().contains("SIM") 
                && !conteudoCampo.toUpperCase().contains("NAO") ){
            throw new RespostaInvalidaException("Resposta incorreta!" +
                        " Por favor responda apenas com SIM ou NAO \n");
        }else if (conteudoCampo.toUpperCase().contains("NAO")){
            return false;
        }
            return true;
    }
    
}
