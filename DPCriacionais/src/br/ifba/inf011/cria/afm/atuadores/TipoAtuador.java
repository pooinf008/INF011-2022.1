package br.ifba.inf011.cria.afm.atuadores;

public enum TipoAtuador {
	
	
	RESFRIADOR("br.ifba.inf011.cria.afm.atuadores.ResfriadorFactory"),
	ESTABILIZADOR("br.ifba.inf011.cria.afm.atuadores.EstabilizadorFactory");

	String factoryName;
	
	TipoAtuador(String factoryName) {
		this.factoryName = factoryName;
	}
	
	public String getFactoryName() {
		return this.factoryName;
	}
	
}
