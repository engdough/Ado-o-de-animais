package ufsc.br.ine5605.adocaoAnimais.Controller;
import ufsc.br.ine5605.adocaoAnimais.Model.Contato;
import ufsc.br.ine5605.adocaoAnimais.Model.Endereco;
import ufsc.br.ine5605.adocaoAnimais.Model.FormularioPessoal;
import ufsc.br.ine5605.adocaoAnimais.Model.Pessoa;
import ufsc.br.ine5605.adocaoAnimais.View.TelaPessoa;
import ufsc.br.ine5605.adocaoAnimais.Exception.RespostaInvalidaException;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IControladorCadastroPessoa;
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorPessoa;
import ufsc.br.ine5605.adocaoAnimais.View.TelaFormularioPessoal;
import ufsc.br.ine5605.adocaoAnimais.View.TelaInfoContato;
import ufsc.br.ine5605.adocaoAnimais.View.TelaInfoEndereco;
import ufsc.br.ine5605.adocaoAnimais.View.TelaInfoPessoal;
import ufsc.br.ine5605.adocaoAnimais.View.TelaMenuPessoas;


/**
 *
 * @author Ana Elisa Kruger
 */
public class ControladorCadastroPessoa{
    
//  implements IControladorCadastroPessoa
    private TelaMenuPessoas telaMenuPessoas = new  TelaMenuPessoas(); 
    private TelaInfoPessoal telaInfoPessoal =  new TelaInfoPessoal();
    private TelaInfoEndereco telaInfoEndereco = new TelaInfoEndereco();
    private TelaInfoContato telaInfoContato = new TelaInfoContato();
    private TelaFormularioPessoal telaFormularioPessoal = new TelaFormularioPessoal();
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private TelaPessoa telaPessoa = new TelaPessoa();
    private Contato contato = new Contato();
    private FormularioPessoal formularioPessoal = new FormularioPessoal();
    private static ControladorCadastroPessoa instancia;
    
    ControladorCadastroPessoa(){
    }
    
    // RETORNA INSTANCIA DO CONTROLADOR (UNICA)
    public static ControladorCadastroPessoa getInstancia(){
        if (instancia == null){
        instancia = new ControladorCadastroPessoa();
        } 
        return instancia;
    } 
    
    public void desativaTelas(){
        telaMenuPessoas.setVisible(false);
        telaInfoPessoal.setVisible(false);
        telaInfoEndereco.setVisible(false);
        telaInfoContato.setVisible(false);
        telaFormularioPessoal.setVisible(false);
    }
    
    public Pessoa getPessoa(){
        return this.pessoa;
    }
    
    // INICIA TELAS  
    public void iniciaInfoPessoal() {
        telaInfoPessoal.setVisible(true);
    }
       
    public void iniciaEndereco(){
        telaInfoEndereco.setVisible(true);
    }
    
    public void iniciaContato(){
        telaInfoContato.setVisible(true);
    }
    
    public void IniciaFormulario(){
        telaFormularioPessoal.setVisible(true);
    }
    public void salvaCadastro(){
        MapeadorPessoa.getInstancia().put(pessoa);
    }
    // PEGA INFORMACOES PESSOAIS 
    public void pegaInfoCpf(String Cpf){
        this.pessoa.setCPF(Cpf);
        System.out.println(pessoa.getCpf());
    }
    
    public String pegaInfoNome(String nome) throws Exception{
        while(!validaCampoEmBranco(nome)){
            throw new Exception();
        }
        this.pessoa.setNome(nome);
        System.out.println(pessoa.getNome());
        return nome;
    }
    
    public String pegaInfoIdade(String idade) throws Exception{
        while(!validaCampoEmBranco(idade)){
            throw new Exception();
        }
        this.pessoa.setIdade(idade);
        return idade;       
    }
     
    // INFO ENDERECO 
    public void salvaInfoEndereco(){
        this.pessoa.setEndereco(endereco);
    }
    public void pegaInfoCep(String Cep){
//        while(!validaCep(cep)){
//            telaPessoa.mensagemErro("CEP invalido! Por favor digite" +
//                    " apenas numero (O CEP deve conter 8 numeros) \n");
//            cep = this.telaPessoa.getCampo("Digite aqui o CEP DA" +
//                    " RESIDENCIA do cidadao:");   
//        }
        this.endereco.setCep(Cep);
        System.out.println(endereco.getCep());
    }

    public void pegaInfoRua(String rua){
        this.endereco.setRua(rua);
        System.out.println(endereco.getRua());
    }
    
     public void pegaInfoNumero(String numero){
        this.endereco.setNumero(numero);
        System.out.println(endereco.getNumero());
     }
    
    public void pegaInfoBairro(String bairro){
        this.endereco.setBairro(bairro);
        System.out.println(endereco.getBairro());
    }
    
    public void pegaInfoCidade(String cidade){
        this.endereco.setCidade(cidade);
        System.out.println(endereco.getCidade());
    }
    
    public void pegaInfoEstado(String estado){
        this.endereco.setEstado(estado);
        System.out.println(endereco.getEstado());
    }
 
    // INFO CONTATO 
    public void salvaInfoContato(){
        this.pessoa.setContato(contato);
    }
    public void pegaInfoEmail(String email){
        this.contato.setEmail(email);
        System.out.println(contato.getEmail());
    }
    
    public void pegaInfoCelular(String telefoneCelular){
//        while(!validaTelefone(telefoneCelular)){
//            telaPessoa.mensagemErro("Numero de telefone invalido! " +
//                    "Por favor digite apenas numeros \n");
//            telefoneCelular = this.telaPessoa.getCampo("Digite aqui um" +
//                    " TELEFONE CELULAR para contato com o cidadao:");   
//        }
        this.contato.setTelefoneCelular(telefoneCelular);
        System.out.println(contato.getTelefoneCelular());
        
    }
    
    public void pegaInfoTelFixo(String telefoneFixo){
//        while(!validaTelefone(telefoneFixo)){
//            telaPessoa.mensagemErro("Numero de telefone invalido!" +
//                   " Por favor digite apenas numeros \n");
//            telefoneFixo = this.telaPessoa.getCampo("Digite aqui um " +
//                    "TELEFONE FIXO para contato com o cidadao:");   
//        }
        this.contato.setTelefoneFixo(telefoneFixo);
        System.out.println(contato.getTelefoneFixo());
    }
    
   // INFO FORMULARIO PESSOAL 
    public void salvaInfoFormulario(){
        pessoa.setFormularioPessoal(formularioPessoal);
    }
    
    public void pegaInfoAdotouAntes(boolean adotouAntes){
        this.formularioPessoal.setAdotouAntes(adotouAntes);
        System.out.println(formularioPessoal.getAdotouAntes());
        
    }    
    
    public void pegaInfoTemQuintal(boolean temQuintal){
        this.formularioPessoal.setTemQuintal(temQuintal);
        System.out.println(formularioPessoal.getTemQuintal());
    }
        
    public void pegaInfoTemTempoPassear(boolean temTempoPassear){
        this.formularioPessoal.setTemTempoPassear(temTempoPassear);
        System.out.println(formularioPessoal.getTemTempoPassear());
    }

    public void pegaInfoTemOutrosAnimais(boolean temOutrosAnimais) {
         this.formularioPessoal.setTemOutrosAnimais(temOutrosAnimais);
         System.out.println(formularioPessoal.getTemOutrosAnimais());
    }
    
    // VALIDACOES
    
    public boolean validaCampoEmBranco (String textoCampo){
         if(textoCampo.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
    public boolean validaCep(String cep) {
        return cep.matches("[0-9]{8}");
    }
    
    public boolean validaIdade(String idade) {
        return idade.matches("[0-9]{0,3}") && Double.valueOf(idade) <= 130;
    }
    
    public boolean validaTelefone(String numero) {
        return numero.matches("[0-9]{1,13}");
    }
}
