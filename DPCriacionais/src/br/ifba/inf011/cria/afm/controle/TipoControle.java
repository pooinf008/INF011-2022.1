package br.ifba.inf011.cria.afm.controle;

public enum TipoControle {
	FAIXA("br.ifba.inf011.cria.afm.controle.ControleFaixaFactory"),
	ALTA("br.ifba.inf011.cria.afm.controle.ControleAltaFactory");
	
	String factoryName;
	
	TipoControle(String factoryName) {
		this.factoryName = factoryName;
	}
	
	public String getFactoryName() {
		return this.factoryName;
	}	
	
}
