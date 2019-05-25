package ufsc.br.ine5605.adocaoAnimais.Controller;
import java.util.ArrayList;
import java.util.Date;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IControladorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorAdocao;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAdocao;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaAcompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.ConteudoTelaFormularioAcompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.FormularioAcompanhamento;
import ufsc.br.ine5605.adocaoAnimais.Model.Adocao;
import ufsc.br.ine5605.adocaoAnimais.Model.Acompanhamento;
import ufsc.br.ine5605.adocaoAnimais.View.TelaAdocao;
import ufsc.br.ine5605.adocaoAnimais.View.TelaExclusaoAdocao;
import ufsc.br.ine5605.adocaoAnimais.View.TelaListaAcompanhamentoVerificaCodigoAdocao;
import ufsc.br.ine5605.adocaoAnimais.View.TelaListaAdocoes;
import ufsc.br.ine5605.adocaoAnimais.View.TelaNovaAdocao;
import ufsc.br.ine5605.adocaoAnimais.View.TelaNovoAcompanhamento1;


public class ControladorAdocao implements IControladorAdocao {

    private MapeadorAdocao mapeadorAdocao;
    private TelaAdocao telaAdocao;
    private ControladorAnimal controladorAnimal;
    private ControladorPrincipal controladorPrincipal;
    private TelaNovaAdocao telaNovaAdocao;
    private TelaExclusaoAdocao telaExclusaoAdocao;
    private TelaListaAdocoes telaListaAdocoes;
    private TelaListaAcompanhamentoVerificaCodigoAdocao telaListaAcompanhamento;
    private TelaNovoAcompanhamento1 telaNovoAcompanhamento;
        
    public ControladorAdocao (ControladorPrincipal controladorPrincipal, ControladorAnimal controladorAnimal){
    	this.controladorAnimal = controladorAnimal;
    	this.mapeadorAdocao = new MapeadorAdocao();
    	this.controladorPrincipal = controladorPrincipal;
    }
	
	public void mostraMenuAdocao() {
		telaAdocao = new TelaAdocao(this, controladorAnimal);
	}
	
	public void executaMenuAdocao(String opcao) {
		int opcaoConvertida = Integer.parseInt(opcao);
		switch(opcaoConvertida) {
			case 0 : controladorPrincipal.iniciaSistema();
				break;
			case 1 : telaNovaAdocao = new TelaNovaAdocao(this, controladorAnimal);
				break;
			case 2 : telaNovoAcompanhamento = new TelaNovoAcompanhamento1(this, controladorAnimal);
				break;
			case 3 : telaExclusaoAdocao = new TelaExclusaoAdocao(this, controladorAnimal);
				break;
			case 4 : listaAdocoes();
				break;
			case 5 : telaListaAcompanhamento = new TelaListaAcompanhamentoVerificaCodigoAdocao(this, controladorAnimal);
				break;
			default : mostraMenuAdocao();
				break;
			
		}
	}
	
	public void adicionaAdocao(ConteudoTelaAdocao conteudoTelaAdocao) {
		Date hoje = new Date();
		int codigo = geraCodigo();
		conteudoTelaAdocao.setCodigo(codigo);
		conteudoTelaAdocao.setData(hoje);
		
		Adocao adocao = desempacotaAdocao(conteudoTelaAdocao);
		
		mapeadorAdocao.put(adocao);
		mostraMenuAdocao();
	}
	
	public Adocao desempacotaAdocao(ConteudoTelaAdocao conteudoTelaAdocao) {
		return new Adocao(conteudoTelaAdocao.getCodigo(), conteudoTelaAdocao.getAnimal(), conteudoTelaAdocao.getPessoa(), conteudoTelaAdocao.getData());
	}
	
	public ConteudoTelaAdocao empacotaAdocao(Adocao adocao) {
		return new ConteudoTelaAdocao(adocao.getCodigo(), adocao.getAnimal(), adocao.getPessoa(), adocao.getData(), adocao.getAcompanhamento());
	}
	
	public void adicionaAcompanhamento(ConteudoTelaAcompanhamento conteudoTelaAcompanhamento, ConteudoTelaFormularioAcompanhamento conteudoTelaFormulario, int codigoAdocao) {
		Date hoje = new Date();
		conteudoTelaAcompanhamento.setData(hoje);
		
		Acompanhamento acompanhamento = desempacotaAcompanhamento(conteudoTelaAcompanhamento, conteudoTelaFormulario);
		
		buscaAdocao(codigoAdocao).inserirAcompanhamento(acompanhamento);
		mapeadorAdocao.persist();
		mostraMenuAdocao();
	}
	
	public Acompanhamento desempacotaAcompanhamento(ConteudoTelaAcompanhamento conteudoTelaAcompanhamento, ConteudoTelaFormularioAcompanhamento conteudoTelaFormulario) {
		FormularioAcompanhamento formularioAcompanhamento = new FormularioAcompanhamento(conteudoTelaFormulario.isAnimalLimpo(), conteudoTelaFormulario.isAnimalMagro(), conteudoTelaFormulario.isAnimalFerido(), conteudoTelaFormulario.isAnimalFoiVeterinario(), conteudoTelaFormulario.getMotivoIdaVeterinario(), conteudoTelaFormulario.isAnimalMedicado(), conteudoTelaFormulario.getQualMedicamento(), conteudoTelaFormulario.getObs());;
		
		return new Acompanhamento(conteudoTelaAcompanhamento.getFuncionario(), conteudoTelaAcompanhamento.getData(), formularioAcompanhamento);
	}
	
	public ConteudoTelaAcompanhamento empacotaAcompanhamento(Acompanhamento acompanhamento) {
		FormularioAcompanhamento formularioAcompanhamento = acompanhamento.getFormulario();
		ConteudoTelaFormularioAcompanhamento conteudoTelaFormulario = new ConteudoTelaFormularioAcompanhamento(formularioAcompanhamento.isAnimalLimpo(), formularioAcompanhamento.isAnimalMagro(), formularioAcompanhamento.isAnimalFerido(), formularioAcompanhamento.isAnimalFoiVeterinario(), formularioAcompanhamento.getMotivoIdaVeterinario(), formularioAcompanhamento.isAnimalMedicado(), formularioAcompanhamento.getQualMedicamento(), formularioAcompanhamento.getObs());
		
		return new ConteudoTelaAcompanhamento(acompanhamento.getFuncionario(), acompanhamento.getData(), conteudoTelaFormulario);
	}

	
	public Adocao buscaAdocao(int codigoAdocao) {
		for(Adocao adocao : mapeadorAdocao.getList()) {
			if (adocao.getCodigo() == codigoAdocao) {
				return adocao;
			}
		}
		return null;
	}
	
	public void excluirAdocao(int codigoAdocao) {
		mapeadorAdocao.remove(buscaAdocao(codigoAdocao));
		mostraMenuAdocao();
	}
	
	public void listaAdocoes() {
		ArrayList<ConteudoTelaAdocao> listagemAdocoes = new ArrayList<>();
		
		for (Adocao adocao : mapeadorAdocao.getList()) {
			listagemAdocoes.add(empacotaAdocao(adocao));
		}
		
		telaListaAdocoes = new TelaListaAdocoes(this, controladorAnimal, listagemAdocoes);
	}
	
	public ArrayList<ConteudoTelaAcompanhamento> listagemAcompanhamento(int codigoAdocao) {
		Adocao adocao = buscaAdocao(codigoAdocao);
		ArrayList<ConteudoTelaAcompanhamento> listagemAcompanhamentos = new ArrayList<>();
		
		for (Acompanhamento acompanhamento : adocao.getAcompanhamento()) {
			listagemAcompanhamentos.add(empacotaAcompanhamento(acompanhamento));
		}
		
		return listagemAcompanhamentos;
	}
	
	public int geraCodigo(){
        int codigoNumerico = 0;
        if(!mapeadorAdocao.listaVazia()){
            codigoNumerico =
                 (mapeadorAdocao.get(Integer.toString(mapeadorAdocao.tamanhoLista()- 1)).getCodigo()) + 1;
        }
        //String codigoAnimal = String.valueOf(codigoNumerico);
        return codigoNumerico;  
    }
	
	public boolean codigoValido(String codigo) {
		if(codigo.matches("[0-9]")) {
			int codigoConvertido = Integer.parseInt(codigo);
			for(Adocao adocao : mapeadorAdocao.getList()) {
				if(adocao.getCodigo() == codigoConvertido) {
					return true;
				}
			}
		}
		
		return false;
	}

}