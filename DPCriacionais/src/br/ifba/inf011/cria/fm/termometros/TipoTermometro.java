package br.ifba.inf011.cria.fm.termometros;

public enum TipoTermometro {
	
	
	BASICO("br.ifba.inf011.cria.fm.termometros.TermometroBasicoFactory"),
	ALTA("br.ifba.inf011.cria.fm.termometros.TermometroAltaFactory");

	String factoryName;
	
	TipoTermometro(String factoryName) {
		this.factoryName = factoryName;
	}
	
	public String getFactoryName() {
		return this.factoryName;
	}
	
}
