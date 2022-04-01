package br.ifba.inf011.cria.afm.termometros;

public enum TipoTermometro {
	
	
	BASICO("br.ifba.inf011.cria.afm.termometros.TermometroBasicoFactory"),
	FAIXA("br.ifba.inf011.cria.afm.termometros.TermometroFaixaFactory"),
	ALTA("br.ifba.inf011.cria.afm.termometros.TermometroAltaFactory");

	String factoryName;
	
	TipoTermometro(String factoryName) {
		this.factoryName = factoryName;
	}
	
	public String getFactoryName() {
		return this.factoryName;
	}
	
}
