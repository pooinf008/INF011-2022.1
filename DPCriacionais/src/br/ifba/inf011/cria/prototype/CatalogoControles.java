package br.ifba.inf011.cria.prototype;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.cria.prototype.controle.Controle;
import br.ifba.inf011.cria.prototype.controle.ControleBuilderTipo2;
import br.ifba.inf011.cria.prototype.controle.ControleIF;

public class CatalogoControles {
	
	private Map<String, ControleIF> controles;
	
	
	public CatalogoControles() {
		this.controles = new HashMap<String, ControleIF>();
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
		this.controles.put("Controle Faixa Padrão", controlador);
		
		Controle controlador2 = (Controle) controleBuilder.reset()
								.adicionarEstabilizador(30, 40)
								.adicionarTermometroFaixa(30, 40)
								.adicionarSaidaErro(System.out)
								.adicionarSaidaPadrao(System.err)
								.build();
		
		this.controles.put("Controle Faixa Alta Temperatura", controlador2);
		
		Controle controlador3 = (Controle) controleBuilder.reset()
				.adicionarResfriador(28)
				.adicionarTermometroAlta(28)
				.adicionarSaidaErro(System.out)
				.adicionarSaidaPadrao(System.err)
				.build();	
		
		this.controles.put("Controle Alta Padrão", controlador3);
		
	}
	
	public ControleIF get(String tipo) {
		return (ControleIF) this.controles.get(tipo).clonar();
	}
	
	

}
