package br.ifba.inf011.cria.fm.termometros;

public class TermometroAltaFactory extends TermometroFactory{

	public TermometroAltaFactory() {
		
	}
	
	public TermometroAltaFactory(double temperatura) {
		super(temperatura);
	}

	@Override
	public TermometroIF criaTermometro() {
		return new TermometroAlta(30);
	}
	
	

}