package br.ifba.inf011.cria.singleton;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.cria.singleton.controle.Controle;
import br.ifba.inf011.cria.singleton.controle.ControleBuilderTipo2;
import br.ifba.inf011.cria.singleton.controle.ControleIF;

public class CatalogoControles {
	
	private Map<TipoControle, ControleIF> controles;
	
	
	public CatalogoControles() {
		this.controles = new HashMap<TipoControle, ControleIF>();
		this.carregarControles();
	}
	
	private void carregarControles() {
		
		ControleBuilderTipo2 controleBuilder = new ControleBuilderTipo2();
		Controle controlador = (Controle) controleBuilder.reset()
					   							.adicionarEstabilizador(26, 28)
					   							.adicionarTermometroFaixa(26, 28)
					   							.adicionarSaidaErro(System.out)
					   							.adicionarSaidaPadrao(System.err)
					   							.build();		
		this.controles.put(TipoControle.FaixaPadrao, controlador);
		
		Controle controlador2 = (Controle) controleBuilder.reset()
								.adicionarEstabilizador(30, 40)
								.adicionarTermometroFaixa(30, 40)
								.adicionarSaidaErro(System.out)
								.adicionarSaidaPadrao(System.err)
								.build();
		
		this.controles.put(TipoControle.FaixaAlta, controlador2);
		
		Controle controlador3 = (Controle) controleBuilder.reset()
				.adicionarResfriador(28)
				.adicionarTermometroAlta(28)
				.adicionarSaidaErro(System.out)
				.adicionarSaidaPadrao(System.err)
				.build();	
		
		this.controles.put(TipoControle.AltaPadrao, controlador3);
		
	}
	
	public ControleIF get(TipoControle tipo) {
		return (ControleIF) this.controles.get(tipo).clonar();
	}
	
	

}
