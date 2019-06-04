package ufsc.br.ine5605.adocaoAnimais.View;
import java.util.Scanner;
import ufsc.br.ine5605.adocaoAnimais.Exception.RespostaInvalidaException;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.ITelaPessoa;
/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaPessoa implements ITelaPessoa{
    Scanner sc = new Scanner(System.in);

    public void imprimeMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String getCampo(String mensagem) {
        System.out.println(mensagem);
        String conteudoCampo = sc.nextLine();
        return conteudoCampo;
    }

    public void mensagemErro(String mensagemErro) {
        System.out.println(mensagemErro);
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
